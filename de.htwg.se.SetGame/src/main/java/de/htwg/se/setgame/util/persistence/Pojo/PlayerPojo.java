package de.htwg.se.setgame.util.persistence.Pojo;

import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.IPlayer;

/**
 * Created by Pavan on 22/05/2015.
 */
public class PlayerPojo implements IPlayer {
    private int id;
    private String playerName=" d";
    private int score = 0;

    public int getId() {
        return id;
    }

    /**
     * @return Get player name.
     */
    @Override
    public String getName() {
        return null;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name Set player name.
     */
    @Override
    public void setName(String name) {

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

    /**
     * @return Return IGame instance
     */
    @Override
    public IGame getGame() {
        return null;
    }

    /**
     * @param game IGame instance
     */
    @Override
    public void setGame(IGame game) {

    }
}
