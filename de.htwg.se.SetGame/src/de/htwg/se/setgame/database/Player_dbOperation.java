package de.htwg.se.setgame.database;

import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.PlayerDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Pavan on 16/05/2015.
 */
public class Player_dbOperation implements PlayerDao{
    private ISession hibernateSession= null;
    private IPlayer player=null;
    private ModelFactory modelFactory;

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
        return null;
    }

    @Override
    public IPlayer getByName(String name) {
        return null;
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
        Session session=getSession();
        Transaction t=session.beginTransaction();
        session.saveOrUpdate(player);
        t.commit();
        session.close();
    }

}
