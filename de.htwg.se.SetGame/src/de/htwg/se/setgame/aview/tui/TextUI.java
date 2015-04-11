package de.htwg.se.setgame.aview.tui;

import org.apache.log4j.Logger;

import com.google.inject.Inject;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.util.observer.Event;
import de.htwg.se.setgame.util.observer.IObserver;

/**
 * @author raina
 *
 */
public class TextUI implements IObserver {

    public static final String MESSAGE_WELCOME = "Welcome to SetGame!!!!\nWell it is not that hard to play ;)\nHave fun!!!";
	private static final int ZERO = 0;

    private IController controller;
	private ActionList actions;
	private String newLine = System.getProperty("line.separator");
	private Logger logger = Logger.getLogger("de.htwg.se.setgame.aview.tui");

	/**
	 * @param controller Instance of IController
	 */
	@Inject
	public TextUI(IController controller) {
		this.controller = controller;
		controller.addObserver(this);
		actions = new ActionList(controller);
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
		logger.info(newLine + controller.getCardinGame().size());

		if (!controller.stillSetInGame() || controller.getCardinGame().isEmpty()) {
			lastMessage();
			return false;
		}

		boolean cont = true;
		String[] splintWords = line.split(" ");
		int index = ZERO;
		String cmd = splintWords[index];
		if (actions.get(cmd) != null) {
			logger.info(actions.get(cmd).execute(splintWords));
		}
		return cont;

	}

	/**
	 * Shows TUI main menu.
	 */
	public void printTUI() {
		logger.info(MESSAGE_WELCOME);
		logger.info(getMenu());
		logger.info(controller.getField());
	}

	private String getMenu() {
		StringBuilder builder = new StringBuilder("MENU:\n");
		for (Action action: actions.getAll()) {
			addMenuEntry(action, builder);
		}
		return builder.toString();
	}

	private void addMenuEntry(Action action, StringBuilder builder) {
		builder.append(action.getCommand());
		builder.append(": ");
		builder.append(action.getDescription());
		builder.append("\n");
	}
}