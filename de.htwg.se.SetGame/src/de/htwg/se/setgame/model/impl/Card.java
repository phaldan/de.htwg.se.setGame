package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICard;

import java.util.Arrays;

/**
 * @author David Simon & Raina Bertolini
 */
public class Card implements ICard {

    public static final String COLOR_1 = "red";
    public static final String COLOR_2 = "green";
    public static final String COLOR_3 = "purple";
    public static final String[] COLOR = {COLOR_1, COLOR_2, COLOR_3};
    public static final String FORM_1 = "ovally";
    public static final String FORM_2 = "wave";
    public static final String FORM_3 = "balk";
    public static final String[] FORM = {FORM_1, FORM_2, FORM_3};
    public static final String FILL_1 = "halffill";
    public static final String FILL_2 = "fill";
    public static final String FILL_3 = "empty";
    public static final String[] FILL = {FILL_1, FILL_2, FILL_3};
    public static final Integer COUNT_1 = 1;
    public static final Integer COUNT_2 = 2;
    public static final Integer COUNT_3 = 3;
    public static final Integer[] COUNT = {COUNT_1, COUNT_2, COUNT_3};
    public static final String SEPARATOR = "|";

    private String color;
    private String form;
    private String panelFilling;
    private Integer count;

    /**
     * Default constructor
     */
    protected Card() {}

    @Override
    public String getColor() {
        return color;
    }

    /**
     * @param color set the color of a card
     * @throws IllegalArgumentException if the color is not allowed
     */
    public void setColor(String color) {
        if (Arrays.asList(COLOR).contains(color)) {
            this.color = color;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String getForm() {
        return form;
    }

    /**
     * @param form set the form of the Card
     * @throws IllegalArgumentException if the form is not allowed
     */
    public void setForm(String form) {
        if (Arrays.asList(FORM).contains(form)) {
            this.form = form;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String getPanelFilling() {
        return panelFilling;
    }

    /**
     * @param panelFilling filling of the card
     * @throws IllegalArgumentException if filling is not allowed
     */
    public void setPanelFilling(String panelFilling) {
        if (Arrays.asList(FILL).contains(panelFilling)) {
            this.panelFilling = panelFilling;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Integer getNumberOfComponents() {
        return count;
    }

    /**
     * @param numberOfComponents number of components
     * @throws IllegalArgumentException if numberOfComponents is not allowed
     */
    public void setNumberOfComponents(int numberOfComponents) {
        if (Arrays.asList(COUNT).contains(numberOfComponents)) {
            this.count = numberOfComponents;
        } else {
            throw new IllegalArgumentException();
        }
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

    @Override
    public boolean compareTo(ICard card) {
        return compareColor(card) && compareCount(card) && compareForm(card) && compareFill(card);
    }

    private boolean compareColor(ICard card) {
        return color.equals(card.getColor());
    }

    private boolean compareForm(ICard card) {
        return form.equals(card.getForm());
    }

    private boolean compareFill(ICard card) {
        return panelFilling.equals(card.getPanelFilling());
    }

    private boolean compareCount(ICard card) {
        return count.equals(card.getNumberOfComponents());
    }
}
