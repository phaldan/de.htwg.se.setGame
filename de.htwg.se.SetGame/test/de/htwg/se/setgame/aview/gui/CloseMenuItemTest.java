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
public class CloseMenuItemTest {

    private CloseMenuItem target;
    private Controller controller;
    private Dialog dialog;
    private Object paneMessage;
    private int paneMessageType;
    private int paneOptionType;
    private Object paneValue;
    private Component component;
    private String dialogTitle;
    private boolean dialogVisible;
    private boolean exit;

    private class Pane extends JOptionPane {

        @Override
        public void setMessage(Object newMessage) {
            paneMessage = newMessage;
        }

        @Override
        public void setMessageType(int newType) {
            paneMessageType = newType;
        }

        @Override
        public void setOptionType(int newType) {
            paneOptionType = newType;
        }

        @Override
        public JDialog createDialog(Component parentComponent, String title) throws HeadlessException {
            component = parentComponent;
            dialogTitle = title;
            return dialog;
        }

        @Override
        public Object getValue() {
            return paneValue;
        }
    }

    private class Dialog extends JDialog {

        @Override
        public void setVisible(boolean b) {
            dialogVisible = b;
        }
    }

    private class Controller extends ControllerDummy {

        @Override
        public void exit() {
            exit = true;
        }
    }

    @Before
    public void setUp() {
        controller = new Controller();
        target = new CloseMenuItem(controller, new Pane());
        exit = false;
    }

    @Test
    public void initial() {
        assertEquals(controller, target.getController());
        assertEquals(CloseMenuItem.TEXT, target.getText());
    }

    @Test
    public void execute_success() {
        dialog = new Dialog();
        paneValue = JOptionPane.YES_OPTION;
        target.execute();

        assertExecute();
        assertTrue(exit);
    }

    @Test
    public void execute_fail() {
        dialog = new Dialog();
        paneValue = JOptionPane.NO_OPTION;
        target.execute();

        assertExecute();
        assertFalse(exit);
    }

    private void assertExecute() {
        assertEquals(CloseMenuItem.MESSAGE, paneMessage);
        assertEquals(JOptionPane.QUESTION_MESSAGE, paneMessageType);
        assertEquals(JOptionPane.YES_NO_OPTION, paneOptionType);
        assertEquals(target, component);
        assertEquals(CloseMenuItem.TITLE, dialogTitle);
        assertTrue(dialogVisible);
    }
}
