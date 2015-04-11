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
	public static final String MENU_HEADLINE = "MENU:%n";
	public static final String FIELD_HEADLINE = "FIELD:%n";

    private IController controller;
	private ActionList actions;
	private boolean cont = true;
	private String newLine = System.getProperty("line.separator");
	private Logger logger = Logger.getLogger("de.htwg.se.setgame.aview.tui");

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
		printTUI();
	}

	private void lastMessage() {
		logger.info("Hey dude! there are no longer sets in game for you, here are the points ;) "
				+ this.newLine
				+ "Player 1 = "
				+ controller.getPlayerOnePoints()
				+ this.newLine
				+ "Player Two " + controller.getPlayerTwoPoints());
		if (controller.getPlayerTwoPoints() < controller.getPlayerOnePoints()) {
			logger.info("Congratulations player one! Dude you are amazing!!");
		} else if (controller.getPlayerTwoPoints() > controller
				.getPlayerOnePoints()) {
			logger.info("Congratulations player two! Dude you are amazing!!");
		} else {
			logger.info("nobody wins nobody pays the dine! xD");
		}
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
		StringBuilder builder = new StringBuilder(String.format(MENU_HEADLINE));
		for (Action action: actions.getAll()) {
			builder.append(String.format(MENU, action.getCommand(), action.getDescription()));
		}
		logger.info(builder.toString());
	}

	private void printField() {
		StringBuilder builder = new StringBuilder(String.format(FIELD_HEADLINE));
		for (Map.Entry<Integer, ICard> entry: controller.getCardsAndTheIndexOfCardInField().entrySet()) {
			builder.append(String.format(FIELD, entry.getKey(), entry.getValue()));
		}
		logger.info(builder.toString());
	}
}