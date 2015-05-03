package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.ControllerDummy;
import de.htwg.se.setgame.model.*;
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
    private IPlayer player;
    private ISet set;
    private Object paneMessage;
    private Object[] paneOptions;
    private Object paneValue;
    private boolean paneVisible;
    private String paneTitle;

    private class Controller extends ControllerDummy {

        @Override
        public List<IPlayer> getPlayers() {
            List<IPlayer> players = new LinkedList<>();
            players.add(player);
            return players;
        }

        @Override
        public ISet createSet() {
            return set;
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
            super(new ControllerDummy());
        }

        @Override
        public List<ICard> getSelected() {
            return new LinkedList<>();
        }
    }

    @Before
    public void setUp() {
        player = new PlayerDummy();
        target = new SetButton(new Controller(), new PaneMock(), new Field());
    }

    @Test
    public void update_success() {
        target.update(new EventDummy());
    }

    @Test
    public void actionPerformed_success() {
        assertActionPerformed(player);
    }

    private void assertActionPerformed(Object value) {
        set = new SetDummy();
        paneValue = value;
        target.actionPerformed(null);

        assertTrue(paneVisible);
        assertEquals(SetButton.DIALOG_TITLE, paneTitle);
        assertEquals(SetButton.DIALOG_MESSAGE, paneMessage);
        assertNotNull(paneOptions);
        assertTrue(paneOptions.length > 0);

        //TODO check parameter of IController.add() call
    }
}
