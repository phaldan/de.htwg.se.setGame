package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.ControllerDummy;
import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class MenuBarTest {

    @Test
    public void test() {
        new MenuBar(new ControllerDummy());
    }
}
