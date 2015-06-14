package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.util.persistence.ISession;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.util.persistence.DaoManager;
import de.htwg.se.setgame.util.persistence.GameDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Pavan on 22/05/2015.
 */
public class Game_dbOperation implements GameDao {
    private DaoManager daoManager;
    private IGame game=null;
    private ISession hibernateSession=null;


       private Session getSession(){
           daoManager=new DaoManager_Operation();
          return (Session) hibernateSession.configureSession();
    }


    @Override
    public IGame create() {
        return null;

    }

    @Override
    public List<IGame> getByPlayer() {
        return null;
    }


    public  List<IGame> getByPlayer(String name) {
        Session session = getSession();
        Transaction t=null;
        List<IGame> gameList=null;
        try {
            t = session.beginTransaction();
            Query query = session.createQuery("from PLAYER where PLAYER.PLAYER_NAME=" + name + "");
            gameList =  query.list();
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
        return gameList;
    }

    @Override
    public void add(IGame game) {
        addOrUpdateOperation(game);
    }

    @Override
    public void update(IGame game) {
        addOrUpdateOperation(game);
    }


    public void addOrUpdateOperation(IGame game){
        Session session=getSession();
        Transaction t=null;
        try {
            t = session.beginTransaction();
            session.saveOrUpdate(game);
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
