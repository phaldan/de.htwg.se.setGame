package de.htwg.se.setgame.model;

/**
 * @author Philipp Daniels
 */
public class PlayerStub extends PlayerDummy {

    private String name;
    private int score;

    public PlayerStub(String playerName, int playerScore) {
        name = playerName;
        score = playerScore;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getScore() {
        return score;
    }
}
