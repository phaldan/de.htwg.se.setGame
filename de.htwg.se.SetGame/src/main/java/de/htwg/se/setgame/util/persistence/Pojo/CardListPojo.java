package de.htwg.se.setgame.util.persistence.Pojo;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Pavan on 22/05/2015.
 */
public class CardListPojo implements ICardList {
    private int id;
    private List<ICard> cards = new LinkedList<>();

    /**
     * @param card Instance of ICard
     */
    @Override
    public void addCard(ICard card) {

    }

    /**
     * @param card Instance of ICard
     * @return Returns removed ICard instance, or null
     */
    @Override
    public ICard removeCard(ICard card) {
        return null;
    }

    public List<ICard> getCards() {
        return cards;
    }

    /**
     * @return Return IGame instance
     */
    @Override
    public IGame getGame() {
        return null;
    }

    /**
     * @param game IGame instance
     */
    @Override
    public void setGame(IGame game) {

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
