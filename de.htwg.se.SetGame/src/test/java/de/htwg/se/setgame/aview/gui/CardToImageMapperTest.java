package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.model.CardDummy;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
 * @author Philipp Daniels
 */
public class CardToImageMapperTest {

    private CardToImageMapper target;

    private class CardStub extends CardDummy {
    }

    @Before
    public void setUp() {
        target = new CardToImageMapper();
    }

    private void assertGetImage(int index) {
        String name = String.format(CardToImageMapper.NAME, index);
        assertEquals(name, target.getImage(new CardStub()));
    }

    @Test
    public void getImage_success() {
        assertGetImage(1);
    }
}
