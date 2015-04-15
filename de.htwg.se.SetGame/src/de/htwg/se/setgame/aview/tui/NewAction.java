package de.htwg.se.setgame.aview.tui;

import de.htwg.se.setgame.controller.IController;

/**
 * @author Philipp Daniels
 */
public class NewAction extends Action {

    public static final String CMD = "n";
    public static final String DESC = "For a newGame.";
    public static final String OUTPUT = "Create a new a game instance.";

    /**
     * @param controller Instance of IController
     */
    public NewAction(IController controller) {
        super(controller);
    }

    @Override
    public String getCommand() {
        return CMD;
    }

    @Override
    public String getDescription() {
        return DESC;
    }

    @Override
    public String execute(String[] input) {
        getController().newGame();
        return OUTPUT;
    }
}
