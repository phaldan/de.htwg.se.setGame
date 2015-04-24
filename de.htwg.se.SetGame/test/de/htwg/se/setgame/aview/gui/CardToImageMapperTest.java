package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.aview.tui.CardDummy;
import de.htwg.se.setgame.model.impl.Card;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Philipp Daniels
 */
public class CardToImageMapperTest {

    private CardToImageMapper target;
    private String color;
    private int count;
    private String fill;
    private String form;

    private class CardStub extends CardDummy {

        @Override
        public String getColor() {
            return color;
        }

        @Override
        public Integer getNumberOfComponents() {
            return count;
        }

        @Override
        public String getPanelFilling() {
            return fill;
        }

        @Override
        public String getForm() {
            return form;
        }
    }

    @Before
    public void setUp() {
        target = new CardToImageMapper();
    }

    private void assertGetImage(String color, int count, String fill, String form, int index) {
        this.color = color;
        this.count = count;
        this.fill = fill;
        this.form = form;
        String name = String.format(CardToImageMapper.NAME, index);
        assertEquals(name, target.getImage(new CardStub()));
    }

    @Test
    public void getImage_success_first() {
        assertGetImage(Card.COLOR_1, Card.COUNT_3, Card.FILL_1, Card.FORM_2, 19);
    }

    @Test
    public void getImage_success_second() {
        assertGetImage(Card.COLOR_3, Card.COUNT_2, Card.FILL_2, Card.FORM_1, 66);
    }

    @Test
    public void getImage_success_third() {
        assertGetImage(Card.COLOR_2, Card.COUNT_1, Card.FILL_3, Card.FORM_3, 35);
    }
}
