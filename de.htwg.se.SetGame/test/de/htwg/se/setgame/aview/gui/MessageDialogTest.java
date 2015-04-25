package de.htwg.se.setgame.aview.gui;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class MessageDialogTest {

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
        public JDialog createDialog(String title) throws HeadlessException {
            paneTitle = title;
            return new Dialog();
        }
    }

    private class Dialog extends JDialog {

        @Override
        public void setVisible(boolean b) {
            dialogVisible = b;
        }
    }

    private Object paneMessage;
    private int paneMessageType;
    private int paneOptionType;
    private String paneTitle;
    private boolean dialogVisible;
    private MessageDialog target;

    @Before
    public void setUp() {
        paneMessage = null;
        paneMessageType = 0;
        paneOptionType = 0;
        paneTitle = null;
        dialogVisible = false;

        target = new MessageDialog(new Pane());
    }

    @Test
    public void constructor() {
        new MessageDialog();
    }

    @Test
    public void test() {
        target.show("Title", "Message");

        assertEquals("Title", paneTitle);
        assertEquals("Message", paneMessage);
        assertEquals(JOptionPane.INFORMATION_MESSAGE, paneMessageType);
        assertEquals(JOptionPane.DEFAULT_OPTION, paneOptionType);
        assertTrue(dialogVisible);
    }
}
