package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.IOptionValue;
import de.htwg.se.setgame.util.persistence.OptionValueDao;
import de.htwg.se.setgame.util.persistence.hibernate.pojo.OptionValueHibernate;

/**
 * @author Philipp Daniels
 */
public class OptionValueDaoHibernate implements OptionValueDao {

    private final HibernateBase db;

    protected OptionValueDaoHibernate(HibernateBase db) {
        this.db = db;
    }

    @Override
    public IOptionValue create() {
        return new OptionValueHibernate();
    }

    @Override
    public void add(IOptionValue value) {
        db.persist(value);
    }

    @Override
    public void update(IOptionValue value) {
        db.persist(value);
    }
}
