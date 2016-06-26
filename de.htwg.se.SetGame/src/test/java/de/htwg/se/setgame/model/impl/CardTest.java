package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICardOption;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CardTest {

    private Card target;

    @Before
    public void setUp() {
        target = new Card();
    }

    @Test
    public void toString_success() {
        Option option = new Option();
        option.setName("Count");

        OptionValue optionValue = new OptionValue();
        optionValue.setValue("one");
        optionValue.setOption(option);

        CardOption cardOption = new CardOption();
        cardOption.setCard(target);
        cardOption.setOption(optionValue);

        target.getCardOptions().add(cardOption);

        String string = target.toString();
        assertTrue(string.contains("Count"));
        assertTrue(string.contains("one"));
    }

    @Test
    public void setId_success() {
        target.setId(1337);
        assertEquals(new Integer(1337), target.getId());
    }

    @Test
    public void setCardList_success() {
        CardList entity = new CardList();
        target.setCardList(entity);
        assertSame(entity, target.getCardList());
    }

    @Test
    public void getCardList_success() {
        java.util.Set<ICardOption> list = new LinkedHashSet<>();
        target.setCardOptions(list);
        assertNotNull(target.getCardOptions());
        assertSame(list, target.getCardOptions());
    }
}
