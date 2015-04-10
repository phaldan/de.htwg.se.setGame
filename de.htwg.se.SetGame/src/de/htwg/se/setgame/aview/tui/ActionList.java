package de.htwg.se.setgame.aview.tui;

import de.htwg.se.setgame.controller.IController;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Philipp Daniels
 */
public class ActionList {

    private Map<String, Action> map = new TreeMap<>();

    public ActionList(IController controller) {
        add(new HelpAction(controller));
    }

    private void add(Action action) {
        map.put(action.getCommand(), action);
    }

    public Action get(String command) {
        return map.get(command);
    }
}
