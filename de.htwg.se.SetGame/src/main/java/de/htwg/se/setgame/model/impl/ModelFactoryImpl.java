package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.*;

/**
 * @author Philipp Daniels
 */
public class ModelFactoryImpl implements ModelFactory {

    @Override
    public ISet createSet() {
        return new Set();
    }

    @Override
    public ICardList createCardList() {
        return new CardList();
    }

    @Override
    public ICard createCard() {
        return new Card();
    }

    @Override
    public IPlayer createPlayer() {
        return new Player();
    }

    @Override
    public IGame createGame() {
        return new Game();
    }

    @Override
    public IOption createOption() {
        return new Option();
    }

    @Override
    public IOptionValue createOptionValue() {
        return new OptionValue();
    }

    @Override
    public ICardOption createCardOption() {
        return new CardOption();
    }
}
