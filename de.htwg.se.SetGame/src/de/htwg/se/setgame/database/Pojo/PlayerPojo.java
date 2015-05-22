package de.htwg.se.setgame.database.Pojo;

/**
 * Created by Pavan on 22/05/2015.
 */
public class PlayerPojo {
    private int id;
    private String name;
    private int score = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
