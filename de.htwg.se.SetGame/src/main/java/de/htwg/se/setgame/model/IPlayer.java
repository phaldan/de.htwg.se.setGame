package de.htwg.se.setgame.model;

/**
 * @author Philipp Daniels
 */
public interface IPlayer {

    /**
     * @return Get player id.
     */
    Integer getId();

    /**
     * @return Get player name.
     */
    String getName();

    /**
     * @return Get player score.
     */
    int getScore();

    /**
     * @param id Set player id.
     */
    void setId(Integer id);

    /**
     * @param name Set player name.
     */
    void setName(String name);

    /**
     * @param score Set player score.
     */
    void setScore(int score);

    /**
     * @return Return IGame instance
     */
    IGame getGame();

    /**
     * @param game IGame instance
     */
    void setGame(IGame game);
}
