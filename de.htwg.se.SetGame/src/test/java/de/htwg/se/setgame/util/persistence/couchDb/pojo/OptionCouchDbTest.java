package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import de.htwg.se.setgame.model.IOptionValue;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashSet;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class OptionCouchDbTest {

    private OptionCouchDb target;

    @Before
    public void setUp() throws Exception {
        target = new OptionCouchDb();
    }

    @Test
    public void getName_success() throws Exception {
        target.setName("count");
        assertEquals("count", target.getName());
    }

    @Test
    public void getOptionValues_success() throws Exception {
        LinkedHashSet<IOptionValue> list = new LinkedHashSet<>();
        target.setOptionValues(list);
        assertNotNull(target.getOptionValues());
        assertSame(list, target.getOptionValues());
    }
}