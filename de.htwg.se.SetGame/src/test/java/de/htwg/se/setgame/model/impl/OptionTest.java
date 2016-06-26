package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.IOptionValue;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashSet;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class OptionTest {

    private Option target;

    @Before
    public void setUp() {
        target = new Option();
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
    public void getName_success() throws Exception {
        assertNull(target.getName());
    }

    @Test
    public void setName_success() throws Exception {
        target.setName("count");
        assertEquals("count", target.getName());
    }

    @Test
    public void getOptionValues_success()  throws Exception {
        assertNotNull(target.getOptionValues());
    }

    @Test
    public void setOptionValues_success()  throws Exception {
        LinkedHashSet<IOptionValue> list = new LinkedHashSet<>();
        target.setOptionValues(list);
        assertNotNull(target.getOptionValues());
        assertSame(list, target.getOptionValues());
    }
}