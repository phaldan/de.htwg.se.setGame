package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class OptionValueCouchDbTest {

    private OptionValueCouchDb target;

    @Before
    public void setUp() throws Exception {
        target = new OptionValueCouchDb();
    }

    @Test
    public void getOption_success() throws Exception {
        OptionCouchDb option = new OptionCouchDb();
        target.setOption(option);
        assertSame(option, target.getOption());
    }

    @Test
    public void getValue_success() throws Exception {
        target.setValue("one");
        assertEquals("one", target.getValue());
    }
}