package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.util.persistence.ISession;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.DaoManager;
import de.htwg.se.setgame.util.persistence.PlayerDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Pavan on 16/05/2015.
 */
public class Player_dbOperation implements PlayerDao{
    private ISession hibernateSession= null;
    private IPlayer player=null;
    private DaoManager daoManager;

    public Player_dbOperation(){
    }
    private Session getSession(){
        daoManager = new HibernateManager();
        return hibernateSession.configureSession();
    }

    private void setSession(ISession session){
        this.hibernateSession=session;
    }

    @Override
    public IPlayer create() {
        return null;
    }


    @Override
    public IPlayer getByName(String name) {
        Session session = getSession();
        Transaction t=null;
        try {
            t = session.beginTransaction();
            String hqlClassName="de.htwg.se.setgame.database.Pojo.PlayerPojo";
            String hql = "FROM " + hqlClassName + "   WHERE PLAYER_NAME='";
            hql = hql + name + "'";
            Query query = session.createQuery(hql);
            //Query query = session.createQuery("FROM PLAYER where PLAYER.PLAYER_NAME=" + name + "");
            //player = (IPlayer) query.list();
            System.out.println("############################  query");
            System.out.println(query);
            List  result =  query.list();
            if(result.isEmpty() == false){
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
        Session session = getSession();
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
