package de.htwg.se.setgame.util.persistence.Hibernate;

import de.htwg.se.setgame.util.persistence.ISession;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.persistence.CardDao;
import de.htwg.se.setgame.util.persistence.DaoManager;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Card_dbOperation implements CardDao {
    private ISession hibernateSession= null;
    private ICard card;
    private DaoManager daoManager;


    public Card_dbOperation(){
    }


    private Session getSession(){
        daoManager=new DaoManager_Operation();
        hibernateSession=daoManager.createSession();
        return hibernateSession.configureSession();
    }
    @Override
    public ICard create() {
        daoManager=new DaoManager_Operation();
        card= (ICard) daoManager.getCard();
        return card;

    }

    @Override
    public void add(ICard card) {
        Session session = getSession();
        Transaction tx=null;
        try {
            tx = session.beginTransaction();
            session.save(card);
            tx.commit();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        }
            finally {
                session.close();
            }

    }

    @Override
    public void update(ICard card) {
        Session session =getSession();
        Transaction tx=null;
        try {
             tx = session.beginTransaction();
            session.saveOrUpdate(card);
            tx.commit();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        }
        finally {
            session.close();
        }

    }
}
