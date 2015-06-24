package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.util.persistence.CardDao;

/**
 * @author Philipp Daniels
 */
public class CardGenerator {

    protected static final String COLOR_1 = "red";
    protected static final String COLOR_2 = "green";
    protected static final String COLOR_3 = "purple";
    protected static final String[] COLOR = {COLOR_1, COLOR_2, COLOR_3};
    protected static final String FORM_1 = "ovally";
    protected static final String FORM_2 = "wave";
    protected static final String FORM_3 = "balk";
    protected static final String[] FORM = {FORM_1, FORM_2, FORM_3};
    protected static final String FILL_1 = "halffill";
    protected static final String FILL_2 = "fill";
    protected static final String FILL_3 = "empty";
    protected static final String[] FILL = {FILL_1, FILL_2, FILL_3};
    protected static final Integer COUNT_1 = 1;
    protected static final Integer COUNT_2 = 2;
    protected static final Integer COUNT_3 = 3;
    protected static final Integer[] COUNT = {COUNT_1, COUNT_2, COUNT_3};

    private CardDao dao;
    private ICardList list;

    /**
     * @param dao Instance of ModelFactory
     */
    protected CardGenerator(CardDao dao) {
        this.dao = dao;
    }

    protected void generate(ICardList cardList) {
        list = cardList;
        addForm();
    }

    private void addForm() {
        for (String form : FORM) {
            addFill(form);
        }
    }

    private void addFill(String form) {
        for (String fill : FILL) {
            addColor(form, fill);
        }
    }

    private void addColor(String form, String fill) {
        for (String color : COLOR) {
            addCount(form, fill, color);
        }
    }

    private void addCount(String form, String fill, String color) {
        for (Integer count : COUNT) {
            list.getCards().add(createCard(form, fill, color, count));
        }
    }

    private ICard createCard(String form, String fill, String color, Integer count) {
        ICard card = dao.create();
        card.setNumberOfComponents(count);
        card.setPanelFilling(fill);
        card.setForm(form);
        card.setColor(color);
        card.setCardList(list);
        dao.add(card);
        return card;
    }
}
