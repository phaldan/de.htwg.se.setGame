package de.htwg.se.setgame.database.Hibernate;

import de.htwg.se.setgame.database.ISession;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.util.persistence.GameDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Pavan on 22/05/2015.
 */
public class Game_dbOperation implements GameDao {
    private ModelFactory modelFactory;
    private IGame game=null;
    private ISession hibernateSession=null;
    private Session getSession(){
        return hibernateSession.configureSession();
    }

    private void setSession(ISession session){
        this.hibernateSession=session;
    }

    @Override
    public IGame create() {
        game=modelFactory.createGame();
        return game;
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
