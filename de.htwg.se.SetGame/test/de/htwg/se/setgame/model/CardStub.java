package de.htwg.se.setgame.model;

/**
 * @author Philipp Daniels
 */
public class CardStub extends CardDummy {

    private String color;
    private String form;
    private String fill;
    private Integer count;

    public CardStub(String color, String form, String fill, Integer count) {
        this.color = color;
        this.form = form;
        this.fill = fill;
        this.count = count;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getForm() {
        return form;
    }

    @Override
    public String getPanelFilling() {
        return fill;
    }

    @Override
    public Integer getNumberOfComponents() {
        return count;
    }
}
