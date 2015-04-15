package de.htwg.se.setgame.aview.tui;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Philipp Daniels
 */
public abstract class ActionList {

    private Map<String, Action> map = new TreeMap<>();

    /**
     * @param action Instance of Action
     */
    protected void add(Action action) {
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
