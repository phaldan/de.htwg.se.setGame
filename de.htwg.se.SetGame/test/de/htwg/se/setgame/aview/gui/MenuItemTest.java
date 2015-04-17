package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.aview.ControllerDummy;
import de.htwg.se.setgame.controller.IController;
import org.junit.Test;

import javax.swing.*;

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

        }

    }

    @Test
    public void test() {
        IController c = new ControllerDummy();
        JOptionPane p = new JOptionPane();
        MenuItem target = new Impl(c, "test", p);
        assertEquals(c, target.getController());
        assertEquals("test", target.getText());
        assertEquals(p, target.getPane());
    }
}
