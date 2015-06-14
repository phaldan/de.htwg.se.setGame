package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.util.persistence.Pojo.CardPojo;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.util.persistence.*;

/**
 * Created by Pavan on 22/05/2015.
 */
public class HibernateManager implements DaoManager {
    private CardDao cardDao = null;
    private ICardList cardList = null;

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
