package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.ControllerDummy;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.model.PlayerStub;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.util.List;

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
    private List<IPlayer> players;

    private class Controller extends ControllerDummy {

        @Override
        public void newGame() {
            newGame = true;
        }

        @Override
        public List<IPlayer> getPlayers() {
            return players;
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

        target = new NewMenuItem(controller, pane);
        players = new LinkedList<>();
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
        assertExecute(NewMenuItem.TITLE_RESTART, NewMenuItem.MSG_RESTART);
    }

    @Test
    public void execute_success_nobodyWins() {
        assertExecuteNew(NewMenuItem.TITLE_DRAW, NewMenuItem.MSG_DRAW);
    }

    @Test
    public void execute_success_playerWins() {
        players.add(new PlayerStub("player", 0));
        assertExecuteNew(NewMenuItem.TITLE_WINNER, String.format(NewMenuItem.MSG_WINNER, "player"));
    }

    @Test
    public void execute_success_twoPlayerButNoWinner() {
        players.add(new PlayerStub("player1", 0));
        players.add(new PlayerStub("player2", 0));
        assertExecuteNew(NewMenuItem.TITLE_DRAW, NewMenuItem.MSG_DRAW);
    }

    @Test
    public void execute_success_twoPlayerWinnerIsPlayer1() {
        players.add(new PlayerStub("player1", 10));
        players.add(new PlayerStub("player2", 2));
        assertExecuteNew(NewMenuItem.TITLE_WINNER, String.format(NewMenuItem.MSG_WINNER, "player1"));
    }

    @Test
    public void execute_success_twoPlayerWinnerIsPlayer2() {
        players.add(new PlayerStub("player1", 3));
        players.add(new PlayerStub("player2", 7));
        assertExecuteNew(NewMenuItem.TITLE_WINNER, String.format(NewMenuItem.MSG_WINNER, "player2"));
    }

    private void assertExecuteNew(String title, String message) {
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
