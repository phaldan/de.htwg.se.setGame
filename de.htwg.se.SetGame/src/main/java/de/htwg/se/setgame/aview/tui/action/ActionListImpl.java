package de.htwg.se.setgame.aview.tui.action;

import de.htwg.se.setgame.aview.tui.ActionList;
import de.htwg.se.setgame.controller.IController;

/**
 * @author Philipp Daniels
 */
public class ActionListImpl extends ActionList {

    /**
     * @param controller Instance of IController
     */
    public ActionListImpl(IController controller) {
        add(new HelpAction(controller));
        add(new AddPlayer(controller));
        add(new PointsAction(controller));
        add(new ResizeAction(controller));
        add(new NewAction(controller));
        add(new SolutionAction(controller));
        add(new SolveAction(controller));
        add(new CloseAction(controller));
        add(new SetAction(controller));
    }
}
