package de.htwg.se.setgame.controller.impl.cpu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CpuNormalTest {

    private CpuNormal target;

    @Before
    public void setUp() throws Exception {
        target = new CpuNormal();
    }

    @Test
    public void testGetLevel() throws Exception {
        assertNotNull(target.getLevel());
    }
}