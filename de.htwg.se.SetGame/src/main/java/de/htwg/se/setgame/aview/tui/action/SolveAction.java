package de.htwg.se.setgame.aview.tui.action;

import de.htwg.se.setgame.aview.tui.Action;
import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.model.ISet;

/**
 * @author Philipp Daniels
 */
public class SolveAction extends Action {

    public static final String CMD = "v";
    public static final String DESC = "If you want to solve the set with out knowing.";
    public static final String OUTPUT1 = "Solved: %s";
    public static final String OUTPUT2 = "Could not find a set.\n";

    /**
     * @param controller Instance of IController
     */
    public SolveAction(IController controller) {
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
        ISet set = getController().getSet();
        return set == null ? OUTPUT2 : process(set);
    }

    private String process(ISet set) {
        getController().add(set, null);
        return String.format(OUTPUT1, set);
    }
}
