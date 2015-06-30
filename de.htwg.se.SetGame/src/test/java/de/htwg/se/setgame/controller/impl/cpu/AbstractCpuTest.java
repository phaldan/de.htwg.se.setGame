package de.htwg.se.setgame.controller.impl.cpu;

import de.htwg.se.setgame.controller.ControllerDummy;
import de.htwg.se.setgame.controller.CpuLevel;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.model.ISet;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class AbstractCpuTest {

    private class Cpu extends AbstractCpu {

        public Cpu() {
            super(1);
        }

        @Override
        public CpuLevel getLevel() {
            return null;
        }
    }

    private class Controller extends ControllerDummy {

        @Override
        public void add(ISet set, IPlayer player) {
            called = true;
        }
    }

    private Cpu target;
    private boolean called;

    @Before
    public void setUp() throws Exception {
        target = new Cpu();
        called = false;
    }

    @Test
    public void test() throws Exception {
        Controller c = new Controller();
        target.activate(c);
        target.disable(c);
    }
}