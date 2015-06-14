package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ICardList;

/**
 * @author David Simon & Raina Bertolini
 */
public class Card implements ICard {

    public static final String SEPARATOR = "|";

    private String color;
    private String form;
    private String panelFilling;
    private Integer count;

    /**
     * Default constructor
     */
    protected Card() {
    }

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
    public void setForm(String form) {
        this.form = form;
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
    public Integer getNumberOfComponents() {
        return count;
    }

    @Override
    public void setNumberOfComponents(int numberOfComponents) {
        this.count = numberOfComponents;
    }

    @Override
    public ICardList getCardList() {
        return null;
    }

    @Override
    public void setCardList(ICardList list) {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        addEntry(sb, color);
        addEntry(sb, form);
        addEntry(sb, panelFilling);
        addEntry(sb, count.toString());
        sb.append(SEPARATOR);
        return sb.toString();
    }

    private void addEntry(StringBuilder builder, String string) {
        builder.append(SEPARATOR);
        builder.append(string);
    }
}
