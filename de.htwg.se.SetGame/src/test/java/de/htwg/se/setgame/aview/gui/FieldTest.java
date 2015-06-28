package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.ControllerDummy;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.*;


/**
 * @author Philipp Daniels
 */
public class FieldTest {

    private class GameFieldDummy extends GameField {

        public GameFieldDummy() {
            super(new ControllerDummy());
        }
    }

    private class ClassLoaderDummy extends ClassLoader {}

    private class Dialog extends MessageDialog {

        @Override
        public void show(String title, String message) {
            dialogTitle = title;
            dialogMessage = message;
        }
    }

    private Field target;
    private String dialogTitle;
    private String dialogMessage;

    @Before
    public void setUp() {
        target = new Field(new GameFieldDummy(), new Dialog(), new ClassLoaderDummy());

        dialogTitle = null;
        dialogMessage = null;
    }

    @Test
    public void isSelected_success() {
        assertFalse(target.isSelected());
        assertNull(target.getIcon());
    }

    @Test
    public void actionPerformed_success() {
        target.actionPerformed(null);

        assertTrue(target.isSelected());
        assertNull(dialogTitle);
        assertNull(dialogMessage);
    }

    @Test
    public void actionPerformed_fail() {
        target.actionPerformed(null);
        target.actionPerformed(null);

        assertTrue(target.isSelected());
        assertEquals(Field.DIALOG_TITLE, dialogTitle);
        assertEquals(Field.DIALOG_MESSAGE, dialogMessage);
    }

    @Test
    public void reset_success() {
        target.actionPerformed(null);
        target.reset();

        assertFalse(target.isSelected());
    }

    @Test
    public void setImage_success() {
        target.setImage("test");
        assertNull(target.getIcon());
    }
}
