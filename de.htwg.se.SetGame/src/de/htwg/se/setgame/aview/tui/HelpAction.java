package de.htwg.se.setgame.aview.tui;

import de.htwg.se.setgame.controller.IController;

/**
 * @author Philipp Daniels
 */
public class HelpAction extends Action {

    public static final String CMD = "h";
    public static final String DESC = "If you need a tip";
    public static final String OUTPUT = "A tip your set begins with %s";

    public HelpAction(IController controller) {
        super(controller);
    }

    @Override
    public String getCommand() {
        return HelpAction.CMD;
    }

    @Override
    public String getDescription() {
        return HelpAction.DESC;
    }

    @Override
    public String execute(String[] input) {
        return String.format(HelpAction.OUTPUT, getController().getFirstInSet());
    }
}
