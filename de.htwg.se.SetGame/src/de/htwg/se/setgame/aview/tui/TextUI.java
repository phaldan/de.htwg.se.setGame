package de.htwg.se.setgame.aview.tui;

import de.htwg.se.setgame.model.ICard;
import org.apache.log4j.Logger;

import com.google.inject.Inject;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.util.observer.Event;
import de.htwg.se.setgame.util.observer.IObserver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author raina
 */
public class TextUI implements IObserver {

    public static final String MESSAGE_WELCOME = "Welcome to SetGame!!!!\nWell it is not that hard to play ;)\nHave fun!!!";
	public static final String SEPARATOR = " ";
	public static final String INVALID_ACTION = "Unknown action.";
	public static final String MENU = "%2s: %s%n";
	public static final String FIELD = "%2d: %s%n";
	public static final String MENU_HEADLINE = "MENU:\n";
	public static final String FIELD_HEADLINE = "FIELD:\n";
	public static final String GAME_FINISH = "Hey dude! there are no longer sets in game for you, here are the points ;)";
	public static final String PLAYER_POINTS = "PlayerOne=%d | PlayerTwo=%d";
	public static final String WINNER_NOBODY = "Nobody wins, nobody pays the dine! xD";
	public static final String WINNER_PLAYER1 = "Congratulations PlayerOne!";
	public static final String WINNER_PLAYER2 = "Congratulations PlayerTwo!";

    private IController controller;
	private ActionList actions;
	private boolean cont = true;
	private static final Logger logger = Logger.getLogger("de.htwg.se.setgame.aview.tui");

	/**
	 * @param controller Instance of IController
	 */
	@Inject
	public TextUI(IController controller) {
		this(controller, new ActionList(controller));
	}

	public TextUI(IController controller, ActionList actions) {
		this.controller = controller;
		this.actions = actions;
		controller.addObserver(this);
	}

	@Override
	public void update(Event e) {
		cont = true;
		printTUI();
	}

	/**
	 * @param line Terminal input.
	 * @return Returns true, when the game has not finished.
	 */
	public boolean processInputLine(String line) {
		if (!controller.stillSetInGame() || controller.getCardinGame().isEmpty()) {
			lastMessage();
			return false;
		}
		executeAction(line.split(SEPARATOR));
		return cont;
	}

	private void lastMessage() {
		logger.info(GAME_FINISH);
		logger.info(String.format(PLAYER_POINTS, controller.getPlayerOnePoints(), controller.getPlayerTwoPoints()));
		if (controller.getPlayerTwoPoints() < controller.getPlayerOnePoints()) {
			logger.info(WINNER_PLAYER1);
		} else if (controller.getPlayerTwoPoints() > controller.getPlayerOnePoints()) {
			logger.info(WINNER_PLAYER2);
		} else {
			logger.info(WINNER_NOBODY);
		}
	}

	private void executeAction(String[] inputArray) {
		LinkedList<String> list = new LinkedList<>(Arrays.asList(inputArray));
		Action action = actions.get(list.peekFirst());
		logger.info((action == null) ? INVALID_ACTION : action.execute(inputArray));
	}

	/**
	 * Print
	 */
	public void printTUI() {
		logger.info(MESSAGE_WELCOME);
		printMenu();
		printField();
	}

	private void printMenu() {
		StringBuilder builder = new StringBuilder(MENU_HEADLINE);
		for (Action action: actions.getAll()) {
			builder.append(String.format(MENU, action.getCommand(), action.getDescription()));
		}
		logger.info(builder.toString());
	}

	private void printField() {
		StringBuilder builder = new StringBuilder(FIELD_HEADLINE);
		for (Map.Entry<Integer, ICard> entry: controller.getCardsAndTheIndexOfCardInField().entrySet()) {
			builder.append(String.format(FIELD, entry.getKey(), entry.getValue()));
		}
		logger.info(builder.toString());
	}
}