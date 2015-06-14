package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.util.persistence.GameDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
        addOrUpdateOperation(game);
    }

    @Override
    public void update(IGame game) {
        addOrUpdateOperation(game);
    }

    private void addOrUpdateOperation(IGame game) {
        Session session = getSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.saveOrUpdate(game);
            t.commit();
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
    }
}
