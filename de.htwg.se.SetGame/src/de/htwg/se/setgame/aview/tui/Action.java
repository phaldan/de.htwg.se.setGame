package de.htwg.se.setgame.aview.tui;

import de.htwg.se.setgame.controller.IController;

/**
 * @author Philipp Daniels
 */
public abstract class Action {

    private IController controller;

    public Action(IController controller) {
        this.controller = controller;
    }

    /**
     * @return Return instance of IController
     */
    protected IController getController() {
        return controller;
    }

    /**
     * @return Return command for user input.
     */
    public abstract String getCommand();

    /**
     * @return Return description of action.
     */
    public abstract String getDescription();

    /**
     * @param input User input.
     * @return Return output for terminal.
     */
    public abstract String execute(String[] input);
}
