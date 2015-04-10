package de.htwg.se.setgame.aview.tui;

import de.htwg.se.setgame.controller.IController;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class ActionTest {

    private class Impl extends Action {

        public Impl(IController controller) {
            super(controller);
        }

        @Override
        public String getCommand() {
            return null;
        }

        @Override
        public String getDescription() {
            return null;
        }

        @Override
        public String execute(String[] input) {
            return null;
        }
    }

    @Test
    public void constructor() {
        IController controller = new ControllerDummy();
        Impl action = new Impl(controller);
        assertEquals(controller, action.getController());
    }
}
