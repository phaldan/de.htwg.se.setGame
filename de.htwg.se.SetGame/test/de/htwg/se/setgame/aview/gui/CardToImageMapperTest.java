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
        assertGetImage(CardToImageMapper.COLOR_1, CardToImageMapper.COUNT_3, CardToImageMapper.FILL_1, CardToImageMapper.FORM_2, 19);
    }

    @Test
    public void getImage_success_second() {
        assertGetImage(CardToImageMapper.COLOR_3, CardToImageMapper.COUNT_2, CardToImageMapper.FILL_2, CardToImageMapper.FORM_1, 66);
    }

    @Test
    public void getImage_success_third() {
        assertGetImage(CardToImageMapper.COLOR_2, CardToImageMapper.COUNT_1, CardToImageMapper.FILL_3, CardToImageMapper.FORM_3, 35);
    }
}
