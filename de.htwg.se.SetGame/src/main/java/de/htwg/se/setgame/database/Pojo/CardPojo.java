package de.htwg.se.setgame.database.Pojo;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ICardList;

/**
 * Created by Pavan on 22/05/2015.
 */
public class CardPojo implements ICard{
    private String color;
    private String form;
    private String panelFilling;
    private Integer count;
 private int id;
    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getPanelFilling() {
        return panelFilling;
    }

    /**
     * @return number of components
     */
    @Override
    public Integer getNumberOfComponents() {
        return null;
    }

    public void setPanelFilling(String panelFilling) {
        this.panelFilling = panelFilling;
    }

    /**
     * @param numberOfComponents set count of card
     */
    @Override
    public void setNumberOfComponents(int numberOfComponents) {

    }

    /**
     * @return ICardList instance
     */
    @Override
    public ICardList getCardList() {
        return null;
    }

    /**
     * @param list ICardList instance
     */
    @Override
    public void setCardList(ICardList list) {

    }

    public Integer getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
