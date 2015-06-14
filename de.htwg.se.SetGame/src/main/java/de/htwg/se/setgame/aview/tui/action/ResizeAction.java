package de.htwg.se.setgame.aview.tui.action;

import de.htwg.se.setgame.aview.tui.Action;
import de.htwg.se.setgame.controller.IController;

/**
 * @author Philipp Daniels
 */
public class ResizeAction extends Action {

    public static final String CMD = "r";
    public static final String DESC = "Resize field size (3-80)";
    public static final String OUTPUT = "Resize field to %s";
    public static final int INDEX = 1;

    /**
     * @param controller Instance of IController
     */
    public ResizeAction(IController controller) {
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
        return (input.length > INDEX) ? process(input[INDEX]): null;
    }

    private String process(String size) {
        int number = Integer.parseInt(size);
        getController().setFieldSize(number);
        return String.format(OUTPUT, size);
    }
}
