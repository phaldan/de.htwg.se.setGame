package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.aview.ControllerDummy;
import de.htwg.se.setgame.controller.IController;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.awt.event.ActionEvent;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class MenuItemTest {

    private class Impl extends MenuItem {

        public Impl(IController controller, String text, JOptionPane pane) {
            super(controller, text, pane);
        }

        @Override
        public void execute() {
            execute = true;
        }
    }

    private MenuItem target;
    private ControllerDummy controller;
    private JOptionPane pane;
    private boolean execute;

    @Before
    public void setUp() {
        controller = new ControllerDummy();
        pane = new JOptionPane();
        execute = false;

        target = new Impl(controller, "test", pane);
    }

    @Test
    public void constructor() {
        assertEquals(controller, target.getController());
        assertEquals("test", target.getText());
        assertEquals(pane, target.getPane());
    }

    @Test
    public void actionPerformed_fail() {
        MenuItem different = new Impl(controller, "", pane);
        target.actionPerformed(new ActionEvent(different, 0, ""));
        assertFalse(execute);
    }

    @Test
    public void actionPerformed_success() {
        target.actionPerformed(new ActionEvent(target, 0, ""));
        assertTrue(execute);
    }
}
