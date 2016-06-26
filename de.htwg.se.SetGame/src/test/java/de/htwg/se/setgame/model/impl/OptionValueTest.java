package de.htwg.se.setgame.model.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class OptionValueTest {

    private OptionValue target;

    @Before
    public void setUp() throws Exception {
        target = new OptionValue();
    }

    @Test
    public void getId_success() throws Exception {
        assertNull(target.getId());
    }

    @Test
    public void setId_success() throws Exception {
        target.setId(1337);
        assertEquals(new Integer(1337), target.getId());
    }

    @Test
    public void getOption_success() throws Exception {
        assertNull(target.getOption());
    }

    @Test
    public void setOption_success() throws Exception {
        Option option = new Option();
        target.setOption(option);
        assertSame(option, target.getOption());
    }

    @Test
    public void getValue_success() throws Exception {
        assertNull(target.getValue());
    }

    @Test
    public void setValue_success() throws Exception {
        target.setValue("one");
        assertEquals("one", target.getValue());
    }
}