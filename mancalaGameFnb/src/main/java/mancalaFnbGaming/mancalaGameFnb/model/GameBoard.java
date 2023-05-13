package mancalaFnbGaming.mancalaGameFnb.model;

import static mancalaFnbGaming.mancalaGameFnb.gameConstant.Player.ONE;
import static mancalaFnbGaming.mancalaGameFnb.gameConstant.Player.TWO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mancalaFnbGaming.mancalaGameFnb.gameConstant.Constant;
import mancalaFnbGaming.mancalaGameFnb.gameConstant.Player;

/**
 * Defines the number of pits and the number of stones located in each pit
 */
public class GameBoard {

	private static final Logger LOGGER = LoggerFactory.getLogger(GameBoard.class);
	private final static int INITIAL_STONE_COUNT = 6;
	private int[] pitStones;

	public GameBoard() {
		this.pitStones = new int[]{0, INITIAL_STONE_COUNT, INITIAL_STONE_COUNT, INITIAL_STONE_COUNT,
				INITIAL_STONE_COUNT, INITIAL_STONE_COUNT, INITIAL_STONE_COUNT, 0, INITIAL_STONE_COUNT,
				INITIAL_STONE_COUNT, INITIAL_STONE_COUNT, INITIAL_STONE_COUNT, INITIAL_STONE_COUNT,
				INITIAL_STONE_COUNT};
	}

	public void setPitStones(int[] pitStones) {
		this.pitStones = pitStones;
	}

	/**
	 * Check if a player has won the game
	 */
	public boolean isPlayerFinished(Player player) {
		return player.getRegularPitLocations().stream().mapToInt(playerRegularPit -> playerRegularPit)
				.noneMatch(regularPit -> pitStones[regularPit] > 0);
	}

	private void score(Player player, int value) {
		if (value <= 0) {
			return;
		}
		int scorePitLocation = player.getScorePitLocation();
		pitStones[scorePitLocation] += value;
	}

	public void scoreAllStones(Player player) {
		for (Integer playerRegularPitLocation : player.getRegularPitLocations()) {
			score(player, pitStones[playerRegularPitLocation]);
			pitStones[playerRegularPitLocation] = 0;
		}
	}

	public int[] getPitStones() {
		return pitStones;
	}

	public boolean isNotEmpty(int pos) {
		return pitStones[pos] > 0;
	}

	public void increment(int pos, int val) {
		if (pos >= pitStones.length || pos < 0) {
			LOGGER.warn("invalid position = {}", pos);
			return;
		}
		pitStones[pos] += val;
	}

	public int getScore(Player player) {
		return pitStones[player.getScorePitLocation()];
	}

	public int getOppositePitLocation(int currentPitLocation, Player player) {
		int scorePitLocation = player.getScorePitLocation();
		int diff = currentPitLocation - scorePitLocation;
		int result = scorePitLocation - diff;
		if (result < 0) {
			return pitStones.length - diff;
		}
		return result;
	}

	public String getGameResult() {
		return handleGameEnd(getScore(ONE), getScore(TWO));
	}

	private static String handleGameEnd(int playerOneScore, int playerTwoScore) {
		if (playerOneScore == playerTwoScore) {
			return Constant.playerTieMessage;
		}
		if (playerOneScore > playerTwoScore) {
			return Constant.playerOneWinMessage;
		}
		return Constant.playerTwoWinMessage;
	}

}
