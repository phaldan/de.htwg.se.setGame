package de.htwg.se.setgame.aview.tui.action;

import de.htwg.se.setgame.aview.tui.Action;
import de.htwg.se.setgame.controller.IController;

/**
 * @author Philipp Daniels
 */
public class AddPlayer extends Action {

    public static final String CMD = "a";
    public static final String DESC = "Add new player: a <name>";
    public static final String OUTPUT = "Adding player.";

    /**
     * @param controller Instance of IController
     */
    public AddPlayer(IController controller) {
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
        if (input.length > 1) {
            getController().registerPlayer(input[1]);
            return OUTPUT;
        }
        return null;
    }
}
