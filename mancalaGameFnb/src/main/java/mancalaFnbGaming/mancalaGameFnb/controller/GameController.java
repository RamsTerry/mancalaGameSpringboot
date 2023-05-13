package mancalaFnbGaming.mancalaGameFnb.controller;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mancalaFnbGaming.mancalaGameFnb.Game.MancalaState;
import mancalaFnbGaming.mancalaGameFnb.gameConstant.Constant;

/**
 * Servlet used to handle user input and render game board
 */
@Controller
public class GameController {

	private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class);

	@GetMapping("/")
	public String renderGame(HttpServletRequest request, Map<String, Object> model) {
		final HttpSession session = request.getSession(true);
		final MancalaState gameState = getGameData(session);

		if (gameState.isGameOver()) {
			String winResult = gameState.getGameBoard().getGameResult();
			LOGGER.info("{}", winResult);
			model.put(Constant.GAME_MESSAGE_MODEL, winResult);
			session.invalidate();
		}
		model.put(Constant.PIT_STONE_MODEL, gameState.getGameBoard().getPitStones());
		model.put(Constant.CURRENT_PLAYER_MODEL, gameState.getCurrentPlayer());
		return Constant.BOARD_VIEW;
	}

	@GetMapping("/input/{move}")
	public String handleUserMove(HttpServletRequest request, @PathVariable String move) throws Exception{
		final HttpSession session = request.getSession(true);
		MancalaState gameState = getGameData(session);
		gameState.handleMove(Integer.parseInt(move));
		session.setAttribute(Constant.GAME_DATA_SESSION_KEY, gameState);
		return "redirect:/";
	}

	private MancalaState getGameData(HttpSession session) {
		final Object attribute = session.getAttribute(Constant.GAME_DATA_SESSION_KEY);
		if (attribute == null) {
			LOGGER.debug("Starting new game");
			return new MancalaState();
		}
		return (MancalaState) attribute;
	}

}
