package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.model.IGame;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public interface GameDao {

    /**
     * @return Return new IGame instance
     */
    IGame create();

    /**
     * @return Return list of IGame instances with winner
     */
    List<IGame> getByPlayer();

    /**
     * Create new entry
     * @param game IGame instance
     */
    void add(IGame game);

    /**
     * Update existent entry
     * @param game IGame instance
     */
    void update(IGame game);
}
