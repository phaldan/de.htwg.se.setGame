package de.htwg.se.setgame.model;

/**
 * @author Philipp
 */
public interface ICard {

    /**
     * @return colors
     */
    String getColor();

    /**
     * @return form
     */
    String getForm();


    /**
     * @return filling
     */
    String getPanelFilling();

    /**
     * @return number of components
     */
    Integer getNumberOfComponents();

    /**
     * @return string method
     */
    String toString();

    /**
     * @param color set the color of a card
     */
    void setColor(String color);

    /**
     * @param form set form of card
     */
    void setForm(String form);

    /**
     * @param panelFilling set filling of card
     */
    void setPanelFilling(String panelFilling);

    /**
     * @param numberOfComponents set count of card
     */
    void setNumberOfComponents(int numberOfComponents);
}