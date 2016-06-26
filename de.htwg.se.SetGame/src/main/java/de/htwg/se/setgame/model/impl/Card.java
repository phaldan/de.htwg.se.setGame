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
    private String color;
    private String form;
    private String panelFilling;
    private Integer count;
    private ICardList cardList;
    private Set<ICardOption> cardOptions = new LinkedHashSet<>();

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getForm() {
        return form;
    }

    @Override
    public Integer getNumberOfComponents() {
        return count;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Set<ICardOption> getCardOptions() {
        return cardOptions;
    }

    @Override
    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getPanelFilling() {
        return panelFilling;
    }

    @Override
    public void setPanelFilling(String panelFilling) {
        this.panelFilling = panelFilling;
    }

    @Override
    public void setNumberOfComponents(int numberOfComponents) {
        this.count = numberOfComponents;
    }

    @Override
    public void setCardOptions(Set<ICardOption> list) {
        this.cardOptions = list;
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
