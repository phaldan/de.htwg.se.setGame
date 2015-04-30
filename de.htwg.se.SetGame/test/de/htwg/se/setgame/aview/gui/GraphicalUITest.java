package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.ControllerDummy;
import de.htwg.se.setgame.controller.event.CloseEvent;
import de.htwg.se.setgame.util.observer.Event;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class GraphicalUITest {

    private class PanelDummy extends Panel {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
        }

        @Override
        public void update(Event e) {
        }
    }

    private GraphicalUI target;

    @Before
    public void setUp() {
        target = new GraphicalUI(new ControllerDummy(), new PanelDummy(), new PanelDummy());
    }

    @Test
    public void test() {
        assertEquals(GraphicalUI.TITLE, target.getTitle());
        assertNotNull(target.getJMenuBar());
        assertNotNull(target.getContentPane());
        assertEquals(JFrame.EXIT_ON_CLOSE, target.getDefaultCloseOperation());
    }

    @Test
    public void update_success() {
        target.setVisible(true);
        target.update(new CloseEvent());
        assertFalse(target.isVisible());
    }
}
