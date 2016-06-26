package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.IOption;
import de.htwg.se.setgame.util.persistence.OptionDao;
import de.htwg.se.setgame.util.persistence.hibernate.pojo.OptionHibernate;

/**
 * @author Philipp Daniels
 */
public class OptionDaoHibernate implements OptionDao {

    private final HibernateBase db;

    protected OptionDaoHibernate(HibernateBase db) {
        this.db = db;
    }

    @Override
    public IOption create() {
        return new OptionHibernate();
    }

    @Override
    public void add(IOption option) {
        db.persist(option);
    }

    @Override
    public void update(IOption option) {
        db.persist(option);
    }
}
