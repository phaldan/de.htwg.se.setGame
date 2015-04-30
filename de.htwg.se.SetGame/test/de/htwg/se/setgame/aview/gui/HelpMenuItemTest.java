package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.ControllerDummy;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class HelpMenuItemTest {

    private class Pane extends JOptionPane {

        @Override
        public void setMessage(Object newMessage) {
            paneMessage = newMessage;
        }

        @Override
        public void setMessageType(int newType) {
        }

        @Override
        public void setOptionType(int newType) {
        }

        @Override
        public JDialog createDialog(Component parentComponent, String title) throws HeadlessException {
            paneTitle = title;
            return new Dialog();
        }
    }

    private class Dialog extends JDialog {

        @Override
        public void setVisible(boolean b) {
            paneVisible = b;
        }
    }

    private HelpMenuItem target;
    private ControllerDummy controller;
    private Pane pane;
    private Object paneMessage;
    private String paneTitle;
    private boolean paneVisible;

    @Before
    public void setUp() {
        controller = new ControllerDummy();
        pane = new Pane();
        paneMessage = null;
        paneTitle = null;
        paneVisible = false;

        target = new HelpMenuItem(controller, pane);
    }

    @Test
    public void constructor() {
        assertEquals(controller, target.getController());
        assertEquals(pane, target.getPane());
        assertEquals(HelpMenuItem.TEXT, target.getText());
    }

    @Test
    public void execute_success() {
        target.execute();

        assertTrue(paneVisible);
        assertEquals(HelpMenuItem.TITLE, paneTitle);
        assertNotNull(paneMessage);
    }
}
