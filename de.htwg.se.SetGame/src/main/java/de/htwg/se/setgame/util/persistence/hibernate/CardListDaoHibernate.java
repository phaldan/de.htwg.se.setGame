package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.util.persistence.CardListDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CardListDaoHibernate implements CardListDao {

    private HibernateBase hibernate;

    protected CardListDaoHibernate(HibernateBase hibernate) {
        this.hibernate = hibernate;
    }

    @Override
    public ICardList create() {
        return null;
    }

    @Override
    public ICardList getByGame(IGame game) {
        Session session = hibernate.getSession();
        Transaction t = null;
        ICardList iCardList = null;
        try {
            t = session.beginTransaction();
            Query query = session.createQuery("from CARDLIST_CARDS");
            iCardList = (ICardList) query.list();
            t.commit();
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
        return iCardList;
    }

    @Override
    public void add(ICardList list) {
        hibernate.persist(list);
    }

    @Override
    public void update(ICardList list) {
        hibernate.persist(list);
    }
}
