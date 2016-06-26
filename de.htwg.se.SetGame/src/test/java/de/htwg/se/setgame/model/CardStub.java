package de.htwg.se.setgame.model;

import de.htwg.se.setgame.model.impl.CardOption;
import de.htwg.se.setgame.model.impl.OptionValue;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Philipp Daniels
 */
public class CardStub extends CardDummy {

    private String color;
    private String form;
    private String fill;
    private Integer count;
    private Set<ICardOption> cardOptions = new LinkedHashSet<>();

    public CardStub(String color, String form, String fill, Integer count) {
        this.color = color;
        this.form = form;
        this.fill = fill;
        this.count = count;
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
    public String getColor() {
        return color;
    }

    @Override
    public String getForm() {
        return form;
    }

    @Override
    public String getPanelFilling() {
        return fill;
    }

    @Override
    public Integer getNumberOfComponents() {
        return count;
    }

    @Override
    public Set<ICardOption> getCardOptions() {
        return cardOptions;
    }
}
