package de.htwg.se.setgame.model;

import de.htwg.se.setgame.model.impl.CardOption;
import de.htwg.se.setgame.model.impl.OptionValue;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Philipp Daniels
 */
public class CardStub extends CardDummy {
    private Set<ICardOption> cardOptions = new LinkedHashSet<>();

    public CardStub(String color, String form, String fill, Integer count) {
        createOption(color);
        createOption(form);
        createOption(fill);
        createOption(count.toString());
    }

    private void createOption(String option) {
        OptionValue optionValue = new OptionValue();
        optionValue.setValue(option);

        CardOption cardOption = new CardOption();
        cardOption.setCard(this);
        cardOption.setOption(optionValue);
        cardOptions.add(cardOption);
    }

    @Override
    public Set<ICardOption> getCardOptions() {
        return cardOptions;
    }
}
