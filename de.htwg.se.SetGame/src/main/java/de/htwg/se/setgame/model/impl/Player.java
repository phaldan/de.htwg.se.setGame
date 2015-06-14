package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.IPlayer;

/**
 * @author Philipp Daniels
 */
public class Player implements IPlayer {

    private int id;
    private String name;
    private int score = 0;
    private IGame game;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public IGame getGame() {
        return game;
    }

    @Override
    public void setGame(IGame game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return getName();
    }
}
