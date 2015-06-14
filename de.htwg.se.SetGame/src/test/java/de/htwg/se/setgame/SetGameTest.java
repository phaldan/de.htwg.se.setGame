package de.htwg.se.setgame;

import de.htwg.se.setgame.controller.event.CloseEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;

/**
 * @author Philipp Daniels
 */
public class SetGameTest {

    private InputStream input;

    @Before
    public void setUp() {
        this.input = System.in;

        String command = "x";
        InputStream input = new ByteArrayInputStream(command.getBytes());
        System.setIn(input);
    }

    @Test
    public void getInstance_withoutGUI() throws IOException {
        SetGame.clearInstance();
        assertNotNull(SetGame.getInstance(false));
    }

    @Test
    public void getInstance_withGUI() throws IOException {
        SetGame.clearInstance();
        SetGame target = SetGame.getInstance(true);
        target.getIController().notifyObservers(new CloseEvent());

        assertNotNull(target);
    }

    @Test
    public void main_success() throws IOException {
        SetGame.clearInstance();
        SetGame.main(new String[]{});
    }

    @After
    public void tearDown() {
        System.setIn(input);
    }
}
