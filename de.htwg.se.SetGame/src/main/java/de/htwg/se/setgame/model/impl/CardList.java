package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;

import java.util.*;
import java.util.Set;

/**
 * @author Philipp Daniels
 */
public class CardList implements ICardList {

    private Integer id;
    private Set<ICard> cards = new LinkedHashSet<>();
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
    public Set<ICard> getCards() {
        return cards;
    }

    @Override
    public void setCards(Set<ICard> cards) {
        this.cards = cards;
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
