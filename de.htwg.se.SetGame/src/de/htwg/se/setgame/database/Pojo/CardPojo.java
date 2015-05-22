package de.htwg.se.setgame.database.Pojo;

/**
 * Created by Pavan on 22/05/2015.
 */
public class CardPojo {
    private String color;
    private String form;
    private String panelFilling;
    private Integer count;

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getPanelFilling() {
        return panelFilling;
    }

    public void setPanelFilling(String panelFilling) {
        this.panelFilling = panelFilling;
    }

    public Integer getCount() {
        return count;
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
