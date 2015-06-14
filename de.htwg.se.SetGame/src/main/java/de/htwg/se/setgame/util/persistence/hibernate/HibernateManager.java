package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.util.persistence.*;

/**
 * @author Philipp Daniels
 */
public class HibernateManager implements DaoManager {

    @Override
    public CardDao getCard() {
        return new Card_dbOperation();
    }

    @Override
    public CardListDao getCardList() {
        return new CardList_dbOperation();
    }

    @Override
    public PlayerDao getPlayer() {
        return new Player_dbOperation();
    }

    @Override
    public GameDao getGame() {
        return new Game_dbOperation();
    }
}
