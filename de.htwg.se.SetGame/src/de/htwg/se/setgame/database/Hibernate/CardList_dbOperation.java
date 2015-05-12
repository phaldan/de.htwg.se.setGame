package de.htwg.se.setgame.database.Hibernate;

import de.htwg.se.setgame.database.ISession;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.util.persistence.CardListDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class CardList_dbOperation implements CardListDao {

    private ISession session= null;


    public CardList_dbOperation(ISession session){
        this.session=session;
    }

    public Session getSession(){
        return session.configureSession();
    }


    @Override
    public ICardList create() {
        return null;
    }

    @Override
    public ICardList getByGame(IGame game) {
        Session session=loadConfiguration();
        Transaction t = session.beginTransaction();
        ICardList iCardList=null;
        Query query = session.createQuery("from CARDLIST_CARDS");
        iCardList = query.list();
        System.out.println(list);
        t.commit();
        session.close();
        return iCardList;
    }

    @Override
    public void add(ICardList list) {
        Session session=loadConfiguration();
        Transaction t=session.beginTransaction();
        session.persist(list);
        t.commit();
        session.close();
    }

    @Override
    public void update(ICardList list) {


    }


}
