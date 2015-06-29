package de.htwg.se.setgame.controller.cpu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CpuHardTest {

    private CpuHard target;

    @Before
    public void setUp() throws Exception {
        target = new CpuHard();
    }

    @Test
    public void testGetLevel() throws Exception {
        assertNotNull(target.getLevel());
    }
}