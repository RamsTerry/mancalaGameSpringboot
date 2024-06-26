package mancalaFnbGaming.mancalaGameFnb.Game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mancalaFnbGaming.mancalaGameFnb.gameConstant.Player;
import mancalaFnbGaming.mancalaGameFnb.model.MancalaBoard;

import static mancalaFnbGaming.mancalaGameFnb.gameConstant.Player.ONE;

/**
 * Contains logic needed to determine and manipulate game state
 */
public class MancalaState {
	private static final Logger LOGGER = LoggerFactory.getLogger(MancalaState.class);

	private Player currentPlayer;
	private MancalaBoard gameBoard;

	public MancalaState() {
		gameBoard = new MancalaBoard();
		currentPlayer = ONE;
	}

	public boolean isGameOver() {
		for (Player player : Player.values()) {
			if (!gameBoard.isPlayerFinished(player)) {
				continue;
			}
			gameBoard.scoreAllStones(player.getNextPlayer());
			return true;
		}
		return false;
	}

	public void incrementCurrentPlayerScore() {
		incrementCurrentPlayerScore(1);
	}

	public void incrementCurrentPlayerScore(int val) {
		gameBoard.increment(currentPlayer.getScorePitLocation(), val);
	}

	public MancalaBoard getGameBoard() {
		return gameBoard;
	}

	public void setNextPlayer() {
		this.currentPlayer = this.currentPlayer.getNextPlayer();
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void handleMove(int pos) {
		final Player currentPlayer = getCurrentPlayer();
		if (!isValidMove(pos)) {
			LOGGER.info("player {} cannot move pit {}", currentPlayer, pos);
			return;
		}
		moveStones(pos);
	}

	private boolean isValidMove(int pos) {
		return currentPlayer.isValidRegularPitLocation(pos) && gameBoard.isNotEmpty(pos);
	}

	/**
	 * Perform a player's turn by moving the stones between pits
	 *
	 * @param pit the pit selected by the user
	 */
	private void moveStones(int pit) {
		final int[] pitStones = gameBoard.getPitStones();
		final Player currentPlayer = getCurrentPlayer();
		final int enemyScorePitLocation = currentPlayer.getNextPlayer().getScorePitLocation();

		// take stones out of pit
		int stones = pitStones[pit];
		pitStones[pit] = 0;

		while (stones > 0) {
			pit--;
			if (pit == enemyScorePitLocation) {
				pit--;
			}
			if (pit < 0) {
				pit = pitStones.length - 1;
			}

			// distribute
			stones--;
			pitStones[pit]++;
		}

		// if you land in your own pit you get to go again
		if (pit == currentPlayer.getScorePitLocation()) {
			return;
		}

		// if you land in one of your empty board pits then you capture enemies stones
		// and your own
		if (pitStones[pit] == 1 && currentPlayer.isValidRegularPitLocation(pit)) {
			incrementCurrentPlayerScore();
			pitStones[pit] = 0;

			int oppositePit = gameBoard.getOppositePitLocation(pit, currentPlayer);

			// steal enemy stones
			incrementCurrentPlayerScore(pitStones[oppositePit]);
			pitStones[oppositePit] = 0;
		}
		setNextPlayer();
	}
}
