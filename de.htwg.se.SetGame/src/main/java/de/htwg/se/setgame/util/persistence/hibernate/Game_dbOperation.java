package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.util.persistence.GameDao;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public class Game_dbOperation extends HibernateBase implements GameDao {

    protected Game_dbOperation(SessionFactory factory) {
        super(factory);
    }

    @Override
    public IGame create() {
        return null;
    }

    @Override
    public List<IGame> getByPlayer() {
        return null;
    }

    @Override
    public void add(IGame game) {
        persist(game);
    }

    @Override
    public void update(IGame game) {
        persist(game);
    }
}
