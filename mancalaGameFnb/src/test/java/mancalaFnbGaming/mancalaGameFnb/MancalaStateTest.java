package mancalaFnbGaming.mancalaGameFnb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mancalaFnbGaming.mancalaGameFnb.Game.MancalaState;
import mancalaFnbGaming.mancalaGameFnb.gameConstant.Constant;
import mancalaFnbGaming.mancalaGameFnb.gameConstant.Player;
import mancalaFnbGaming.mancalaGameFnb.model.MancalaBoard;

public class MancalaStateTest {
	private MancalaState gameState;

	@BeforeEach
	void setUp() {
		gameState = new MancalaState();
	}

	@Test
	public void testPlayerTwoWins() {
		int[] testBoard = {4, 0, 0, 0, 0, 0, 0, 4, 1, 2, 0, 1, 0, 1};
		gameState.getGameBoard().setPitStones(testBoard);

		gameState.isGameOver();
		MancalaBoard gameBoard = gameState.getGameBoard();
		assertEquals(4, gameBoard.getScore(Player.ONE));
		assertEquals(9, gameBoard.getScore(Player.TWO));
		assertEquals(Constant.playerTwoWinMessage, gameState.getGameBoard().getGameResult());
	}

	@Test
	public void testPlayerOneWins() {
		gameState.setNextPlayer();
		int[] testBoard = {4, 1, 0, 3, 0, 1, 0, 4, 0, 0, 0, 0, 0, 0};
		gameState.getGameBoard().setPitStones(testBoard);

		gameState.isGameOver();
		MancalaBoard gameBoard = gameState.getGameBoard();
		assertEquals(9, gameBoard.getScore(Player.ONE));
		assertEquals(4, gameBoard.getScore(Player.TWO));
		assertEquals(Constant.playerOneWinMessage, gameState.getGameBoard().getGameResult());
	}

	@Test
	public void testPlayerTie() {
		int[] testBoard = {4, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0};
		gameState.getGameBoard().setPitStones(testBoard);

		gameState.isGameOver();
		MancalaBoard gameBoard = gameState.getGameBoard();
		assertEquals(4, gameBoard.getScore(Player.ONE));
		assertEquals(4, gameBoard.getScore(Player.TWO));
		assertEquals(Constant.playerTieMessage, gameState.getGameBoard().getGameResult());
	}


}
