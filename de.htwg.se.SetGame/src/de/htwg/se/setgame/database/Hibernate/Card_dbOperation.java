package de.htwg.se.setgame.database.Hibernate;

import de.htwg.se.setgame.database.ISession;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.model.impl.ModelFactoryImpl;
import de.htwg.se.setgame.util.persistence.CardDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Card_dbOperation implements CardDao {
    private ISession hibernateSession= null;
    private ICard card=null;
    private ModelFactory modelFactory;


    public Card_dbOperation(){
    }

    public void  setSession(ISession session){
        this.hibernateSession=session;
    }


    private Session getSession(){
        return hibernateSession.configureSession();
    }
    @Override
    public ICard create() {
        modelFactory=new ModelFactoryImpl();
        card= modelFactory.createCard();
        return card;

    }

    @Override
    public void add(ICard card) {
        Session session =getSession();
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
