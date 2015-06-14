package de.htwg.se.setgame.aview;

import de.htwg.se.setgame.controller.ControllerDummy;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class ViewFactoryTest {

    private ViewFactory target;

    @Before
    public void setUp() {
        target = new ViewFactory(new ControllerDummy());
    }

    @Test
    public void createGUI_success() {
        target.createGUI();
    }

    @Test
    public void createTUI_success() {
        target.createTUI();
    }
}
