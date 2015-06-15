package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.IPlayer;

import java.util.Set;

/**
 * @author Philipp Daniels
 */
public class GameDummy implements IGame {

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }

    @Override
    public Set<IPlayer> getPlayers() {
        return null;
    }

    @Override
    public void setPlayers(Set<IPlayer> list) {

    }

    @Override
    public ICardList getFieldCardList() {
        return null;
    }

    @Override
    public void setFieldCardList(ICardList list) {

    }

    @Override
    public ICardList getUnusedCardList() {
        return null;
    }

    @Override
    public void setUnusedCardList(ICardList list) {

    }

    @Override
    public IPlayer getWinner() {
        return null;
    }

    @Override
    public void setWinner(IPlayer player) {

    }
}
