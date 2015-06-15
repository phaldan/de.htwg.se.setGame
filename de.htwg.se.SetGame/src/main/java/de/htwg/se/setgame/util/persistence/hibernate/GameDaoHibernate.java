package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.GameDao;
import de.htwg.se.setgame.util.persistence.hibernate.pojo.GameHibernate;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public class GameDaoHibernate implements GameDao {

    private HibernateBase db;

    protected GameDaoHibernate(HibernateBase db) {
        this.db = db;
    }

    @Override
    public IGame create() {
        return new GameHibernate();
    }

    @Override
    public List<IGame> getByPlayer(IPlayer player) {
        List<IGame> list = db.getCriteria(GameHibernate.class)
                .add(Restrictions.eq("player", player))
                .list();
        db.close();
        return list;
    }

    @Override
    public void add(IGame game) {
        db.persist(game);
    }

    @Override
    public void update(IGame game) {
        db.persist(game);
    }
}
