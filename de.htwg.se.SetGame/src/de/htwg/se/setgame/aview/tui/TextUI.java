package de.htwg.se.setgame.aview.tui;

import de.htwg.se.setgame.aview.tui.action.ActionList;
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
	private static final Logger LOGGER = Logger.getLogger("de.htwg.se.setgame.aview.tui");

	/**
	 * @param controller Instance of IController
	 */
	@Inject
	public TextUI(IController controller) {
		this(controller, new ActionList(controller));
	}

	/**
	 * @param controller Instance of IController
	 * @param actions Instance of ActionList
	 */
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

	private void output(String message) {
		LOGGER.info(message);
	}

	private void lastMessage() {
		output(GAME_FINISH);
		output(String.format(PLAYER_POINTS, controller.getPlayerOnePoints(), controller.getPlayerTwoPoints()));
		if (controller.getPlayerTwoPoints() < controller.getPlayerOnePoints()) {
			output(WINNER_PLAYER1);
		} else if (controller.getPlayerTwoPoints() > controller.getPlayerOnePoints()) {
			output(WINNER_PLAYER2);
		} else {
			output(WINNER_NOBODY);
		}
	}

	private void executeAction(String[] inputArray) {
		LinkedList<String> list = new LinkedList<>(Arrays.asList(inputArray));
		Action action = actions.get(list.peekFirst());
		output((action == null) ? INVALID_ACTION : action.execute(inputArray));
	}

	/**
	 * Print
	 */
	public void printTUI() {
		output(MESSAGE_WELCOME);
		printMenu();
		printField();
	}

	private void printMenu() {
		StringBuilder builder = new StringBuilder(MENU_HEADLINE);
		for (Action action: actions.getAll()) {
			builder.append(String.format(MENU, action.getCommand(), action.getDescription()));
		}
		output(builder.toString());
	}

	private void printField() {
		StringBuilder builder = new StringBuilder(FIELD_HEADLINE);
		for (Map.Entry<Integer, ICard> entry: controller.getCardsAndTheIndexOfCardInField().entrySet()) {
			builder.append(String.format(FIELD, entry.getKey(), entry.getValue()));
		}
		output(builder.toString());
	}
}