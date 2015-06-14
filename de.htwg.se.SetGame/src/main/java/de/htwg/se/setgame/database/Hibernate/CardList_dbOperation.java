package de.htwg.se.setgame.database.Hibernate;

import de.htwg.se.setgame.database.ISession;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.util.persistence.CardListDao;
import de.htwg.se.setgame.util.persistence.DaoManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CardList_dbOperation implements CardListDao {

    private ISession hibernateSession= null;
    private ICardList cardList=null;
    private DaoManager daoManager;


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
        daoManager=new DaoManager_Operation();
        cardList=  daoManager.getCardList();
        return cardList;

    }

    @Override
    public ICardList getByGame(IGame game) {
        Session session = getSession();
        Transaction t=null;
        ICardList iCardList = null;
        try {
            t = session.beginTransaction();

            Query query = session.createQuery("from CARDLIST_CARDS");
            iCardList = (ICardList) query.list();
            t.commit();
        }
        catch (Exception e) {
            if (t != null) {
                t.rollback();
                throw e;
            }
        }
        finally {
            session.close();
        }
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
        Transaction t=null;
        try {
             t = session.beginTransaction();
              session.saveOrUpdate(list);
             t.commit();
        }
        catch (Exception e) {
            if (t != null) {
                t.rollback();
                throw e;
            }
        }
        finally {
            session.close();
        }
    }

}
