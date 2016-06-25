package de.htwg.se.setgame;

import org.apache.log4j.Logger;
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
        Logger.getRootLogger().removeAllAppenders();
        Logger.getRootLogger().addAppender(new TestAppender());

        this.input = System.in;
        String command = "x";
        InputStream input = new ByteArrayInputStream(command.getBytes());
        System.setIn(input);
    }

    @After
    public void tearDown() {
        System.setIn(input);
    }

    private void assertGetInstance(boolean gui) {
        SetGame.clearInstance();
        SetGame target = SetGame.getInstance(gui);
        target.getIController().exit();
        assertNotNull(target);
    }

    @Test
    public void getInstance_withoutGUI() throws IOException {
        assertGetInstance(false);
    }

    @Test
    public void getInstance_withGUI() throws IOException {
        assertGetInstance(false);
    }

    @Test
    public void main_success() throws IOException {
        SetGame.clearInstance();
        SetGame.main(new String[]{});
    }
}
