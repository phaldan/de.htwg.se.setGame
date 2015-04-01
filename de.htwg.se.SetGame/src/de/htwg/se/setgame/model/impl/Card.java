package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICard;

/**
 * @author David Simon & Raina Bertolini
 */
public class Card implements ICard {
    private String color;
    private String form;
    private String panelFilling;
    private int count;

    /**
     * This method create a new card object
     *
     * @param color card color
     * @param form card form
     * @param panelFilling card background
     * @param count number of components
     */
    public Card(String color, String form, String panelFilling, int count) {
        this.setColor(color);
        this.setForm(form);
        this.setPanelFilling(panelFilling);
        this.setNumberOfComponents(count);
    }

    @Override
    public String getColor() {
        return color;
    }

    /**
     * @param color set the color of a card
     */
    public void setColor(String color) {
        if (color.equals(Pack.COLORS[0]) || color.equals(Pack.COLORS[1])
                || color.equals(Pack.COLORS[2])) {
            this.color = color;
        } else {
            this.color = null;
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
        if (form.equals(Pack.FORME[2]) || form.equals(Pack.FORME[0])
                || form.equals(Pack.FORME[1])) {
            this.form = form;
        } else {
            this.form = null;
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
        if (panelFilling.equals(Pack.FILL[0])
                || panelFilling.equals(Pack.FILL[1])
                || panelFilling.equals(Pack.FILL[2])) {
            this.panelFilling = panelFilling;
        } else {
            this.panelFilling = null;
        }
    }

    @Override
    public int getNumberOfComponents() {
        return count;
    }

    /**
     * @param numberOfComponents number of components
     * @throws IllegalArgumentException if numberOfComponents is not allowed
     */
    public void setNumberOfComponents(int numberOfComponents) {
        if (numberOfComponents == Pack.NUMBEROFCOMPONET[0]
                || numberOfComponents == Pack.NUMBEROFCOMPONET[1]
                || numberOfComponents == Pack.NUMBEROFCOMPONET[2]) {
            this.count = numberOfComponents;

        } else {
            this.count = -1;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|" + this.color + "| \n " + "|" + this.form + "| \n " + "|"
                + this.panelFilling + "| \n " + "|" + this.count + "|\n");
        return sb.toString();
    }

    @Override
    public boolean compareTo(ICard card) {
        if (this.color.equals(card.getColor()) && this.count == card.getNumberOfComponents()
                && this.form.equals(card.getForm())
                && this.panelFilling.equals(card.getPanelFilling())) {
            return true;
        }
        return false;
    }
}
