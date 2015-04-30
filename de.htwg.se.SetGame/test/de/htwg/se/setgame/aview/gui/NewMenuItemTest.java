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
public class NewMenuItemTest {

    private NewMenuItem target;
    private Controller controller;
    private Pane pane;
    private boolean newGame;
    private Object paneMessage;
    private String paneTitle;
    private boolean paneVisible;
    private Object paneValue;
    private int points1;
    private int points2;

    private class Controller extends ControllerDummy {

        @Override
        public void newGame() {
            newGame = true;
        }

        @Override
        public int getPlayerOnePoints() {
            return points1;
        }

        @Override
        public int getPlayerTwoPoints() {
            return points2;
        }
    }

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

        @Override
        public Object getValue() {
            return paneValue;
        }
    }

    private class Dialog extends JDialog {

        @Override
        public void setVisible(boolean b) {
            paneVisible = b;
        }
    }

    @Before
    public void setUp() {
        controller = new Controller();
        pane = new Pane();
        newGame = false;
        paneVisible = false;
        paneValue = null;
        points1 = 0;
        points2 = 0;

        target = new NewMenuItem(controller, pane);
    }

    @Test
    public void constructor() {
        assertEquals(NewMenuItem.TEXT, target.getText());
        assertEquals(controller, target.getController());
        assertEquals(pane, target.getPane());
    }

    @Test
    public void execute_fail() {
        paneValue = JOptionPane.NO_OPTION;
        target.execute();
        assertFalse(newGame);
        assertExecute(NewMenuItem.TITLE3, NewMenuItem.MESSAGE4);
    }

    @Test
    public void execute_success_nobodyWins() {
        assertExecuteSuccess(NewMenuItem.TITLE2, NewMenuItem.MESSAGE3);
    }

    @Test
    public void execute_success_playerOneWins() {
        points1 = 10;
        assertExecuteSuccess(NewMenuItem.TITLE1, NewMenuItem.MESSAGE1);
    }

    @Test
    public void execute_success_playerTwoWins() {
        points2 = 10;
        assertExecuteSuccess(NewMenuItem.TITLE1, NewMenuItem.MESSAGE2);
    }

    private void assertExecuteSuccess(String title, String message) {
        paneValue = JOptionPane.YES_OPTION;
        target.execute();
        assertTrue(newGame);
        assertExecute(title, message);
    }

    private void assertExecute(String title, String message) {
        assertTrue(paneVisible);
        assertEquals(title, paneTitle);
        assertEquals(message, paneMessage);
    }
}
