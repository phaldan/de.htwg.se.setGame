package de.htwg.se.setgame.model;

import java.util.Set;

/**
 * @author Philipp
 */
public interface ICard {

    /**
     * @return ICardList instance
     */
    ICardList getCardList();

    /**
     * @return colors
     */
    String getColor();

    /**
     * @return form
     */
    String getForm();

    /**
     * @return Return id
     */
    Integer getId();

    /**
     * @return filling
     */
    String getPanelFilling();

    /**
     * @return number of components
     */
    Integer getNumberOfComponents();

    /**
     * @return Return list of ICardOption instances
     */
    Set<ICardOption> getCardOptions();

    /**
     * @param list ICardList instance
     */
    void setCardList(ICardList list);

    /**
     * @param color set the color of a card
     */
    void setColor(String color);

    /**
     * @param form set form of card
     */
    void setForm(String form);

    /**
     * @param id Set identifier
     */
    void setId(Integer id);

    /**
     * @param panelFilling set filling of card
     */
    void setPanelFilling(String panelFilling);

    /**
     * @param numberOfComponents set count of card
     */
    void setNumberOfComponents(int numberOfComponents);

    /**
     * @param list Set list of ICardOption instances
     */
    void setCardOptions(Set<ICardOption> list);

    /**
     * @return string method
     */
    String toString();
}