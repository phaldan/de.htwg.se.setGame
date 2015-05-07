package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;

/**
 * @author Philipp Daniels
 */
public interface CardListDao {

    /**
     * @return Return new ICardList instance
     */
    ICardList create();

    /**
     * @param game IGame instance
     * @return Return ICardList instance with ICards
     */
    ICardList getByGame(IGame game);

    /**
     * Add new entry
     * @param list ICardList instance
     */
    void add(ICardList list);

    /**
     * Update existent entry
     * @param list ICardList instance
     */
    void update(ICardList list);
}
