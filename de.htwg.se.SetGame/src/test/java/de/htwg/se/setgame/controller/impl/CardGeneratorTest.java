package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.model.impl.Card;
import de.htwg.se.setgame.model.impl.CardOption;
import de.htwg.se.setgame.model.impl.Option;
import de.htwg.se.setgame.model.impl.OptionValue;
import de.htwg.se.setgame.util.persistence.CardDaoDummy;
import de.htwg.se.setgame.util.persistence.CardOptionDaoDummy;
import de.htwg.se.setgame.util.persistence.OptionDaoDummy;
import de.htwg.se.setgame.util.persistence.OptionValueDaoDummy;
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

    private class CardDao extends CardDaoDummy {

        @Override
        public ICard create() {
            return new Card();
        }
    }

    private class CardOptionDao extends CardOptionDaoDummy {

        @Override
        public ICardOption create() {
            return new CardOption();
        }
    }

    private class OptionDao extends OptionDaoDummy {

        @Override
        public IOption create() {
            return new Option();
        }
    }

    private class OptionValueDao extends OptionValueDaoDummy {

        @Override
        public IOptionValue create() {
            return new OptionValue();
        }
    }

    private CardGenerator target;
    private Set<ICard> cards;

    @Before
    public void setUp() {
        CardOptions cardOptions = new CardOptions(new OptionDao(), new OptionValueDao());
        target = new CardGenerator(new CardDao(), new CardOptionDao(), cardOptions);
        cards = new LinkedHashSet<>();
    }

    @Test
    public void generate_success() {
        target.generate(new CardListSpy());
        int size = CardGenerator.COLOR.length * CardGenerator.FILL.length * CardGenerator.FORM.length * CardGenerator.COUNT.length;
        assertEquals(size, cards.size());
    }

}
