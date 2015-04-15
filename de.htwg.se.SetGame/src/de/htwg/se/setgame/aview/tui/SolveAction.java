package de.htwg.se.setgame.aview.tui;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.model.ICard;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public class SolveAction extends Action {

    public static final String CMD = "v";
    public static final String DESC = "If you want to solve the set with out knowing.";
    public static final String OUTPUT1 = "Solved: %s";
    public static final String OUTPUT2 = "Could not find a set.\n";
    public static final int PLAYER = 3;
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;

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
        List<ICard> set = getController().getSetInField();
        return set.isEmpty() ? OUTPUT2 : process(set);
    }

    private String process(List<ICard> set) {
        getController().isASetForController(set.get(FIRST), set.get(SECOND), set.get(THIRD), PLAYER);
        return String.format(OUTPUT1, set);
    }
}
