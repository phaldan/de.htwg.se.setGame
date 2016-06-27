package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.model.impl.Card;
import de.htwg.se.setgame.model.impl.CardOption;
import de.htwg.se.setgame.model.impl.Option;
import de.htwg.se.setgame.model.impl.OptionValue;
import de.htwg.se.setgame.util.persistence.*;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class CardGeneratorTest {

    private class CardListSpy extends CardListDummy {

        @Override
        public Set<ICard> getCards() {
            return cards;
        }
    }

    private CardGenerator target;
    private Set<ICard> cards;
    private CardOptions cardOptions;

    @Before
    public void setUp() {
        DaoManagerStub dao = new DaoManagerStub();
        cardOptions = new CardOptions(dao);
        target = new CardGenerator(dao);
        cards = new LinkedHashSet<>();
    }

    @Test
    public void generate_success() {
        target.generate(new CardListSpy());
        int size = 1;
        for (IOption option: cardOptions.getValues()) {
            size = size * option.getOptionValues().size();
        }
        assertEquals(size, cards.size());
    }

}
