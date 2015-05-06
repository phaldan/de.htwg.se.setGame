package de.htwg.se.setgame.aview.tui;

import de.htwg.se.setgame.controller.event.CloseEvent;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IPlayer;
import org.apache.log4j.Logger;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.util.observer.Event;
import de.htwg.se.setgame.util.observer.IObserver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
	public static final String MSG_DRAW = "Nobody wins, nobody pays the dine! xD";
	public static final String MSG_WINNER = "Congratulations %s!";
	public static final String CLOSE = "Stop input processing";

    private IController controller;
	private ActionList actions;
	private boolean cont = true;
	private static final Logger LOGGER = Logger.getLogger("de.htwg.se.setgame.aview.tui");

	/**
	 * @param controller Instance of IController
	 * @param actions Instance of ActionListImpl
	 */
	public TextUI(IController controller, ActionList actions) {
		this.controller = controller;
		this.actions = actions;
		controller.addObserver(this);
	}

	@Override
	public void update(Event e) {
		if (e != null && e.getClass().equals(CloseEvent.class)) {
			cont = false;
			output(CLOSE);
		} else {
			cont = true;
			printTUI();
		}
	}

	/**
	 * @param line Terminal input.
	 * @return Returns true, when the game has not finished.
	 */
	public boolean processInputLine(String line) {
		if (controller.getSet() == null) {
			lastMessage();
			return false;
		}
		executeAction(line.split(SEPARATOR));
		return getContinue();
	}

	private void output(String message) {
		LOGGER.info(message);
	}

	private void lastMessage() {
		output(GAME_FINISH);
		IPlayer player = getWinner();
		if (player != null) {
			output(String.format(MSG_WINNER, player));
		} else {
			output(MSG_DRAW);
		}
	}

	private IPlayer getWinner() {
		List<IPlayer> players = controller.getPlayers();
		int max = -1;
		IPlayer winner = null;
		for (IPlayer player: players) {
			if (player.getScore() > max) {
				max = player.getScore();
				winner = player;
			} else if (player.getScore() == max) {
				winner = null;
			}
		}
		return winner;
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

	/**
	 * @return Return false, when command line input processing will be stopped.
	 */
	protected boolean getContinue() {
		return cont;
	}
}