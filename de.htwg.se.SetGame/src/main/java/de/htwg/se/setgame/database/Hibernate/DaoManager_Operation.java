package de.htwg.se.setgame.database.Hibernate;

import de.htwg.se.setgame.database.ISession;
import de.htwg.se.setgame.database.Pojo.CardListPojo;
import de.htwg.se.setgame.database.Pojo.CardPojo;
import de.htwg.se.setgame.database.Pojo.GamePojo;
import de.htwg.se.setgame.database.Pojo.PlayerPojo;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.util.persistence.*;

/**
 * Created by Pavan on 22/05/2015.
 */
public class DaoManager_Operation implements DaoManager {
    private CardDao cardDao=null;
    private ICardList cardList=null;


    @Override
    public CardPojo getCard(){

        return new CardPojo();
    }

    @Override
    public CardListPojo getCardList() {
        return new CardListPojo();
    }

    @Override
    public PlayerPojo getPlayer() {
        return new PlayerPojo();
    }

    @Override
    public GamePojo getGame() {

        /* Game_dbOperation is yet to be Implemented */
        return new GamePojo();
    }

    /**
     * @return Return instance of GameDao
     */
    @Override
    public ISession createSession() {
        return new HibernateSession();
    }
}
