package de.htwg.se.setgame.database.Hibernate;

import de.htwg.se.setgame.database.ISession;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.model.impl.ModelFactoryImpl;
import de.htwg.se.setgame.util.persistence.CardListDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CardList_dbOperation implements CardListDao {

    private ISession hibernateSession= null;
    private ICardList cardList=null;
    private ModelFactory modelFactory;


    public CardList_dbOperation(){
    }

    private Session getSession(){
        return hibernateSession.configureSession();
    }

    private void setSession(ISession session){
        this.hibernateSession=session;
    }

    @Override
    public ICardList create() {
        modelFactory=new ModelFactoryImpl();
        cardList= modelFactory.createCardList();
        return cardList;
    }

    @Override
    public ICardList getByGame(IGame game) {
        Session session = getSession();
        Transaction t = session.beginTransaction();
        ICardList iCardList=null;
        Query query = session.createQuery("from CARDLIST_CARDS");
        iCardList = (ICardList) query.list();
        t.commit();
        session.close();
        return iCardList;
    }

    @Override
    public void add(ICardList list) {
        addOrUpdateOperation(list);

    }

    @Override
    public void update(ICardList list) {
        addOrUpdateOperation(list);

    }

    public void addOrUpdateOperation(ICardList list){
        Session session=getSession();
        Transaction t=session.beginTransaction();
        session.saveOrUpdate(list);
        t.commit();
        session.close();
    }

}
