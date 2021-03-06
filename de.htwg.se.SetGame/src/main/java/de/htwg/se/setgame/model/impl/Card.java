package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.ICardOption;
import de.htwg.se.setgame.model.IOptionValue;

import java.util.*;
import java.util.Set;

/**
 * @author David Simon & Raina Bertolini
 */
public class Card implements ICard {

    public static final String SEPARATOR = "|";

    private Integer id;
    private ICardList cardList;
    private Set<ICardOption> cardOptions = new LinkedHashSet<>();

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public ICardList getCardList() {
        return cardList;
    }

    @Override
    public void setCardList(ICardList list) {
        this.cardList = list;
    }

    @Override
    public Set<ICardOption> getCardOptions() {
        return cardOptions;
    }

    @Override
    public void setCardOptions(Set<ICardOption> list) {
        this.cardOptions = list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ICardOption option: getCardOptions()) {
            addEntry(sb, option.getOption());
        }
        sb.append(SEPARATOR);
        return sb.toString();
    }

    private void addEntry(StringBuilder builder, IOptionValue value) {
        builder.append(SEPARATOR);
        builder.append(value.getOption().getName());
        builder.append('=');
        builder.append(value.getValue());
    }
}
