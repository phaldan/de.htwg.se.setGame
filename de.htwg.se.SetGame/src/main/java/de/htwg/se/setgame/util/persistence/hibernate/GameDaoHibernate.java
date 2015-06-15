package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.GameDao;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public class GameDaoHibernate implements GameDao {

    private HibernateBase hibernate;

    protected GameDaoHibernate(HibernateBase hibernate) {
        this.hibernate = hibernate;
    }

    @Override
    public IGame create() {
        return null;
    }

    @Override
    public List<IGame> getByPlayer(IPlayer player) {
        return null;
    }

    @Override
    public void add(IGame game) {
        hibernate.persist(game);
    }

    @Override
    public void update(IGame game) {
        hibernate.persist(game);
    }
}
