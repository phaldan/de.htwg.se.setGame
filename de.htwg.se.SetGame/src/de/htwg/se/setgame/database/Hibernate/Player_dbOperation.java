package de.htwg.se.setgame.database.Hibernate;

import de.htwg.se.setgame.database.ISession;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.model.impl.ModelFactoryImpl;
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
        modelFactory=new ModelFactoryImpl();
        player= modelFactory.createPlayer();
        return player;
    }

    @Override
    public IPlayer getByName(String name) {
        Session session = getSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("from PLAYER where PLAYER.PLAYER_NAME="+name+"");
        player = (IPlayer) query.list();
        t.commit();
        session.close();
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
        Session session=getSession();
        Transaction t=session.beginTransaction();
        session.saveOrUpdate(player);
        t.commit();
        session.close();
    }

}
