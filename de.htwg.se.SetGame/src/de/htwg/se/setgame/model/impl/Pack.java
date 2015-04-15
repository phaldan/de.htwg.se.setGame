package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IPack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Simon & Raina Bertolini class use to create all the
 *         combinations of the pack
 */
public class Pack implements IPack {

    private List<ICard> list;

    /**
     * Construct for card
     */
    public Pack() {
        int size = Card.COUNT.length * Card.COLOR.length * Card.FILL.length * Card.COUNT.length;
        list = new ArrayList<>(size);
        initiateList();
    }

    private void initiateList() {
        for (String form : Card.FORM) {
            addFill(form);
        }
    }

    private void addFill(String form) {
        for (String fill : Card.FILL) {
            addColor(form, fill);
        }
    }

    private void addColor(String form, String fill) {
        for (String color : Card.COLOR) {
            addCount(form, fill, color);
        }
    }

    private void addCount(String form, String fill, String color) {
        for (Integer count : Card.COUNT) {
            list.add(createCard(form, fill, color, count));
        }
    }

    private ICard createCard(String form, String fill, String color, Integer count) {
        ICard card = new Card();
        card.setNumberOfComponents(count);
        card.setPanelFilling(fill);
        card.setForm(form);
        card.setColor(color);
        return card;
    }

    @Override
    public List<ICard> getPack() {
        return list;
    }
}
