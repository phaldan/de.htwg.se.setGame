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
public class Player_dbOperation implements PlayerDao{

    private SessionFactory factory;

    public Player_dbOperation(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public IPlayer create() {
        return null;
    }


    @Override
    public IPlayer getByName(String name) {
        IPlayer player = null;
        Session session = factory.openSession();
        Transaction t=null;
        try {
            t = session.beginTransaction();
            String hqlClassName="de.htwg.se.setgame.database.Pojo.PlayerPojo";
            String hql = "FROM " + hqlClassName + "   WHERE PLAYER_NAME='" + name + "'";
            Query query = session.createQuery(hql);
            List result = query.list();
            if(!result.isEmpty()){
                player = (IPlayer) result.get(0);
            }
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

        return player;
    }


    @Override
    public void add(IPlayer player) {
        addOrUpdateOperation(player);
    }

    @Override
    public void update(IPlayer player) {
        addOrUpdateOperation(player);
    }

    public void addOrUpdateOperation(IPlayer player){
        Transaction t=null;
        Session session = factory.openSession();
        try {

             t = session.beginTransaction();
            session.saveOrUpdate(player);
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
