package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.aview.ControllerDummy;
import de.htwg.se.setgame.util.observer.Event;
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

    @Test
    public void test() {
        GraphicalUI target = new GraphicalUI(new ControllerDummy(), new PanelDummy(), new PanelDummy());
        assertEquals(GraphicalUI.TITLE, target.getTitle());
        assertNotNull(target.getJMenuBar());
        assertNotNull(target.getContentPane());
        assertEquals(JFrame.EXIT_ON_CLOSE, target.getDefaultCloseOperation());
    }
}
