package de.htwg.se.setgame.database.Pojo;

import de.htwg.se.setgame.model.ICard;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Pavan on 22/05/2015.
 */
public class CardListPojo {
    private int id;
    private List<ICard> cards = new LinkedList<>();

    public List<ICard> getCards() {
        return cards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCards(List<ICard> cards) {
        this.cards = cards;
    }
}
