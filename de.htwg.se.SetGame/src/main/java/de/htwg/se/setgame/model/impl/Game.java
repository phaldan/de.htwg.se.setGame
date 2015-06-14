package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.IPlayer;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Philipp Daniels
 */
public class Game implements IGame {

    private Integer id;
    private Set<IPlayer> players = new LinkedHashSet<>();
    private ICardList fieldCardList;
    private ICardList unusedCardList;
    private IPlayer winner;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Set<IPlayer> getPlayers() {
        return players;
    }

    @Override
    public void setPlayers(Set<IPlayer> list) {
        players = list;
    }

    @Override
    public ICardList getFieldCardList() {
        return fieldCardList;
    }

    @Override
    public void setFieldCardList(ICardList list) {
        fieldCardList = list;
    }

    @Override
    public ICardList getUnusedCardList() {
        return unusedCardList;
    }

    @Override
    public void setUnusedCardList(ICardList list) {
        unusedCardList = list;
    }

    @Override
    public IPlayer getWinner() {
        return winner;
    }

    @Override
    public void setWinner(IPlayer player) {
        winner = player;
    }
}
