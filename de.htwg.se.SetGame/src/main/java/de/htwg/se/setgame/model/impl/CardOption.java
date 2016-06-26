package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ICardOption;
import de.htwg.se.setgame.model.IOptionValue;

/**
 * @author Philipp Daniels
 */
public class CardOption implements ICardOption {

    private Integer id;
    private ICard card;
    private IOptionValue option;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public ICard getCard() {
        return card;
    }

    @Override
    public void setCard(ICard card) {
        this.card = card;
    }

    @Override
    public IOptionValue getOption() {
        return option;
    }

    @Override
    public void setOption(IOptionValue option) {
        this.option = option;
    }
}
