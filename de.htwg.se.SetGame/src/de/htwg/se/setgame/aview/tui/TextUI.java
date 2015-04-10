package de.htwg.se.setgame.aview.tui;

import org.apache.log4j.Logger;

import com.google.inject.Inject;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.observer.Event;
import de.htwg.se.setgame.util.observer.IObserver;

/**
 * @author raina
 *
 */
public class TextUI implements IObserver {

    public static final String MESSAGE_WELCOME = "Welcome to SetGame!!!!\nWell it is not that hard to play ;)\nIf you found a set please write : set PlayerOne (or PlayerTwo) and the number of the fields 1 2 3 (0-11)\nif you want to know the solution please write s\nif you want to solve the set with out knowing just write solve\nFor a newGame please write nw\nHave fun!!! if you want to finish the game please write exit";

    private IController controller;
	private ActionList actions;
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TWO = 1;
	private static final int THREE = 1;
	private static final int FOUR = 1;
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

	private void setIn(String stringOne, String stringTwo, String stringTree, String player) {
		Integer[] arrayForSerNumber = new Integer[THREE];
		arrayForSerNumber[ZERO] = Integer.parseInt(stringOne);
		arrayForSerNumber[ONE] = Integer.parseInt(stringTwo);
		arrayForSerNumber[TWO] = Integer.parseInt(stringTree);
		boolean b = true;

		for (Integer anArrayForSerNumber : arrayForSerNumber) {
			if (anArrayForSerNumber < ZERO || anArrayForSerNumber > controller.getCardInFieldGame().size()) {
				b = false;
				logger.info(this.newLine + "wrong number please number between 0-11");
				break;
			}
		}
		if (b) {
			printASet(arrayForSerNumber, player);
		}

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
		if (splintWords[index].compareTo("set") == ZERO) {
			if (compareIfPlayerIsRight(splintWords[ONE]) && splintWords.length > FOUR) {
				setIn(splintWords[TWO], splintWords[THREE], splintWords[FOUR], splintWords[ONE]);
			}
		} else if (splintWords[index].compareTo("exit") == ZERO) {
			cont = false;
		}
		proveSomeStringsFromMet(splintWords[index]);

		return cont;

	}

	private void printASet(Integer[] arrayForSerNumber, String string) {
		int player = string.equals("PlayerOne") ? controller.getPlayerOne(): controller.getPlayerTwo();

		ICard cardOne = getCard(arrayForSerNumber, ZERO);
		ICard cardTwo = getCard(arrayForSerNumber, ONE);
		ICard cardThree = getCard(arrayForSerNumber, THREE);

		controller.isASetForController(cardOne, cardTwo, cardThree, player);
		logger.info(newLine + "Congratulations it is a SET!! ! size == "
				+ controller.getField().getCardsInField().size());

	}

	private ICard getCard(Integer[] arrayForSerNumber, int i) {
		return controller.getField().getCardsInField().get(arrayForSerNumber[i]);
	}

	private boolean compareIfPlayerIsRight(String string) {
		return string.equals("PlayerOne") || string.equals("PlayerTwo");
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

	private void solve() {
		if (this.controller.getSetInField().size() >= THREE) {
			logger.info("solved" + this.controller.getSetInField().toString()
					+ newLine
					+ controller.getField().getCardsInField().size());
			this.controller.isASetForController(this.controller.getSetInField()
							.get(ZERO), this.controller.getSetInField().get(ONE),
					this.controller.getSetInField().get(TWO), THREE);
			printTUI();
		} else {
			logger.info("number of cards = "
					+ controller.getField().getCardsInField().size());
			printTUI();

		}
	}

	private void solution() {
		for (ICard card : controller.getSetInField()) {
			for (Integer key : controller.getCardsAndTheIndexOfCardInField().keySet()) {
				if (controller.getCardsAndTheIndexOfCardInField().get(key)
						.compareTo(card)) {
					logger.info("Index  == " + key);
				}

			}
			logger.info(newLine);

		}
	}

	private void newGame() {
		this.controller.newGame();

	}

	private void proveSomeStringsFromMet(String string) {
		if (string.compareTo("solve") == ZERO) {
			solve();
		} else if (string.compareTo("s") == ZERO) {
			solution();

		} else if (string.compareTo("nw") == ZERO) {
			newGame();
		}

	}
}