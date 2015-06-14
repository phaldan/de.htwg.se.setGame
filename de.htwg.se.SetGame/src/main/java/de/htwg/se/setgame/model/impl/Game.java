package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.IPlayer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Philipp Daniels
 */
public class Game implements IGame {

    private Integer id;
    private List<IPlayer> players = new LinkedList<>();
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
    public List<IPlayer> getPlayers() {
        return players;
    }

    @Override
    public void addPlayer(IPlayer player) {
        players.add(player);
    }

    @Override
    public boolean removePlayer(IPlayer player) {
        return players.remove(player);
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
