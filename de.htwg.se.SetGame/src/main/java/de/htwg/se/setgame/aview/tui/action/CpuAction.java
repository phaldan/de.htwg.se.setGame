package de.htwg.se.setgame.aview.tui.action;

import de.htwg.se.setgame.aview.tui.Action;
import de.htwg.se.setgame.controller.IController;

/**
 * @author Philipp Daniels
 */
public class CpuAction extends Action {

    public static final String CMD = "c";
    public static final String OUTPUT1 = "Enable CPU player.";
    public static final String OUTPUT2 = "Disable CPU player";
    public static final String DESC = "Enable CPU player: c <level>";

    /**
     * @param controller Instance of IController
     */
    public CpuAction(IController controller) {
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
        if (input.length <= 1) {
            getController().setCpu(null);
            return OUTPUT2;
        } else {
            getController().setCpu(input[1]);
            return OUTPUT1;
        }
    }
}
