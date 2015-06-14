package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Philipp Daniels
 */
public class CardList implements ICardList {

    private Integer id;
    private List<ICard> cards = new LinkedList<>();
    private IGame game;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void addCard(ICard card) {
        cards.add(card);
    }

    @Override
    public ICard removeCard(ICard card) {
        return cards.remove(card) ? card : null;
    }

    @Override
    public List<ICard> getCards() {
        return cards;
    }

    @Override
    public IGame getGame() {
        return game;
    }

    @Override
    public void setGame(IGame game) {
        this.game = game;
    }
}
