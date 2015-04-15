package de.htwg.se.setgame.aview.tui;

import de.htwg.se.setgame.controller.IController;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Philipp Daniels
 */
public class ActionList {

    private Map<String, Action> map = new TreeMap<>();

    /**
     * @param controller Instance of IController
     */
    public ActionList(IController controller) {
        add(new HelpAction(controller));
        add(new PointsAction(controller));
        add(new ResizeAction(controller));
        add(new NewAction(controller));
        add(new SolutionAction(controller));
        add(new SolveAction(controller));
        add(new CloseAction(controller));
        add(new SetAction(controller));
    }

    private void add(Action action) {
        map.put(action.getCommand(), action);
    }

    /**
     * @param command Identifier of an Action implementation
     * @return Returns instance of Action
     */
    public Action get(String command) {
        return map.get(command);
    }

    /**
     * @return Returns List with all Action implementations
     */
    public List<Action> getAll() {
        return new LinkedList<>(map.values());
    }
}
