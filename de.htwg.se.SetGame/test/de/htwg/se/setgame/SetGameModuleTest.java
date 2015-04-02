package de.htwg.se.setgame;

import com.google.inject.Guice;
import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class SetGameModuleTest {

    @Test
    public void test() {
        Guice.createInjector(new SetGameModule());
    }

}
