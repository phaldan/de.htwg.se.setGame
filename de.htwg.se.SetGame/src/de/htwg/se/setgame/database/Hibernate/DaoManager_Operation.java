package de.htwg.se.setgame.database.Hibernate;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.util.persistence.*;

/**
 * Created by Pavan on 22/05/2015.
 */
public class DaoManager_Operation implements DaoManager {
    private CardDao cardDao=null;
    private ICardList cardList=null;


    @Override
    public CardDao getCard(){

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

        /* Game_dbOperation is yet to be Implemented */
        return new Game_dbOperation();
    }
}
