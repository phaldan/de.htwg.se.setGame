package de.htwg.se.setgame.database.Pojo;

/**
 * Created by Pavan on 22/05/2015.
 */
public class PlayerPojo {
    private int id;
    private String playerName=" d";
    private int score = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
