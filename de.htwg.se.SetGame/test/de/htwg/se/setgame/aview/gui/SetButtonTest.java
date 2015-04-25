package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.aview.ControllerDummy;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.observer.Event;
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
public class SetButtonTest {

    private SetButton target;
    private int player1;
    private int player2;
    private Object paneMessage;
    private Object[] paneOptions;
    private Object paneValue;
    private boolean paneVisible;
    private String paneTitle;

    private class Controller extends ControllerDummy {

        @Override
        public int getPlayerOnePoints() {
            return player1;
        }

        @Override
        public int getPlayerTwoPoints() {
            return player2;
        }
    }

    private class EventDummy implements Event {

    }

    private class PaneMock extends JOptionPane {
        @Override
        public void setMessage(Object newMessage) {
            paneMessage = newMessage;
        }

        @Override
        public void setOptions(Object[] newOptions) {
            paneOptions = newOptions;
        }

        @Override
        public Object getValue() {
            return paneValue;
        }

        @Override
        public JDialog createDialog(Component parentComponent, String title) throws HeadlessException {
            paneTitle = title;
            return new DialogMock();
        }
    }

    private class DialogMock extends JDialog  {

        @Override
        public void setVisible(boolean b) {
            paneVisible = b;
        }
    }

    private class Field extends GameField {

        public Field() {
            super(new Controller());
        }

        @Override
        public List<ICard> getSelected() {
            return new LinkedList<>();
        }
    }

    @Before
    public void setUp() {
        player1 = 0;
        player2 = 0;
        target = new SetButton(new Controller(), new PaneMock(), new Field());
    }

    @Test
    public void initPane_success() {
        assertEquals(SetButton.DIALOG_TITLE, paneTitle);
        assertEquals(SetButton.DIALOG_MESSAGE, paneMessage);
        assertNotNull(paneOptions);
        assertTrue(paneOptions.length > 0);
    }

    @Test
    public void getPlayer1_success() {
        assertNotNull(target.getPlayer1());
        assertEquals(SetButton.DEFAULT_TEXT_FIELD, target.getPlayer1().getText());
    }

    @Test
    public void getPlayer2_success() {
        assertNotNull(target.getPlayer2());
        assertEquals(SetButton.DEFAULT_TEXT_FIELD, target.getPlayer2().getText());
    }

    @Test
    public void update_success() {
        player1 = 2;
        player2 = 5;
        target.update(new EventDummy());

        assertEquals("2", target.getPlayer1().getText());
        assertEquals("5", target.getPlayer2().getText());
    }

    @Test
    public void actionPerformed_success_player1() {
        assertActionPerformed(7, 2, SetButton.PLAYER1);
    }

    @Test
    public void actionPerformed_success_player2() {
        assertActionPerformed(3, 4, SetButton.PLAYER2);
    }

    private void assertActionPerformed(int player1Points, int player2Points, Object value) {
        player1 = player1Points;
        player2 = player2Points;
        paneValue = value;
        target.actionPerformed(null);

        assertTrue(paneVisible);
        assertEquals(Integer.toString(player1Points), target.getPlayer1().getText());
        assertEquals(Integer.toString(player2Points), target.getPlayer2().getText());

        //TODO check parameter of isASetForController call
    }
}
