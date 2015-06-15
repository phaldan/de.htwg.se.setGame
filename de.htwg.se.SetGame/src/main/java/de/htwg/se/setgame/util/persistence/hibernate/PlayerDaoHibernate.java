package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.PlayerDao;
import de.htwg.se.setgame.util.persistence.hibernate.pojo.PlayerHibernate;

/**
 * @author Philipp Daniels
 */
public class PlayerDaoHibernate implements PlayerDao {

    private HibernateBase db;

    protected PlayerDaoHibernate(HibernateBase db) {
        this.db = db;
    }

    @Override
    public IPlayer create() {
        return new PlayerHibernate();
    }

    @Override
    public IPlayer getByName(String name) {
        IPlayer player = (IPlayer) db.getCriteria(PlayerHibernate.class)
                .uniqueResult();
        db.close();
        return player;
    }

    @Override
    public void add(IPlayer player) {
        db.persist(player);
    }

    @Override
    public void update(IPlayer player) {
        db.persist(player);
    }
}
