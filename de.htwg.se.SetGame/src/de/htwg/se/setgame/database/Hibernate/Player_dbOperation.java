package de.htwg.se.setgame.database.Hibernate;

import de.htwg.se.setgame.database.ISession;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.DaoManager;
import de.htwg.se.setgame.util.persistence.PlayerDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        return hibernateSession.configureSession();
    }

    private void setSession(ISession session){
        this.hibernateSession=session;
    }
    @Override
    public IPlayer create() {
        daoManager=new DaoManager_Operation();
        player=  daoManager.getPlayer();
        return player;

    }

    @Override
    public IPlayer getByName(String name) {
        Session session = getSession();
        Transaction t=null;
        try {
            t = session.beginTransaction();
            Query query = session.createQuery("from PLAYER where PLAYER.PLAYER_NAME=" + name + "");
            player = (IPlayer) query.list();
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
