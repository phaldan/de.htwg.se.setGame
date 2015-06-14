package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.PlayerDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public class Player_dbOperation extends HibernateBase implements PlayerDao {

    protected Player_dbOperation(SessionFactory factory) {
        super(factory);
    }

    @Override
    public IPlayer create() {
        return null;
    }

    @Override
    public IPlayer getByName(String name) {
        IPlayer player = null;
        Session session = getSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            String hqlClassName = "de.htwg.se.setgame.database.Pojo.PlayerPojo";
            String hql = "FROM " + hqlClassName + "   WHERE PLAYER_NAME='" + name + "'";
            Query query = session.createQuery(hql);
            List result = query.list();
            if (!result.isEmpty()) {
                player = (IPlayer) result.get(0);
            }
            t.commit();
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
        return player;
    }

    @Override
    public void add(IPlayer player) {
        persist(player);
    }

    @Override
    public void update(IPlayer player) {
        persist(player);
    }
}
