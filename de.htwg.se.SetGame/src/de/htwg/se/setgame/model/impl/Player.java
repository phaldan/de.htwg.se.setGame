package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.IPlayer;

/**
 * @author Philipp Daniels
 */
public class Player implements IPlayer {

    private int id;
    private String name;
    private int score = 0;

    /**
     * @param id Player id.
     * @param name Player name.
     */
    public Player(int id, String name) {
        setId(id);
        setName(name);
    }

    @Override
    public int getId() {
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
    public void setId(int id) {
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
}
