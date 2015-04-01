package de.htwg.se.setgame.model;

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
     * @param card ICard instance
     * @return true if card is the same
     */
    boolean compareTo(ICard card);

}