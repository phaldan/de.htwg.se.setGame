package de.htwg.se.setgame.aview.tui.action;

import de.htwg.se.setgame.aview.tui.Action;
import de.htwg.se.setgame.controller.IController;

/**
 * @author Philipp Daniels
 */
public class CloseAction extends Action {

    public static final String CMD = "x";
    public static final String DESC = "If you want to finish the game.";
    public static final String OUTPUT = "Finish game.";

    /**
     * @param controller Instance of IController
     */
    public CloseAction(IController controller) {
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
        getController().exit();
        return OUTPUT;
    }
}
