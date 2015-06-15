package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.persistence.CardDao;

/**
 * @author Philipp Daniels
 */
public class CardDaoHibernate implements CardDao {

    private HibernateBase hibernate;

    protected CardDaoHibernate(HibernateBase hibernate) {
        this.hibernate = hibernate;
    }

    @Override
    public ICard create() {
        return null;
    }

    @Override
    public void add(ICard card) {
        hibernate.persist(card);
    }

    @Override
    public void update(ICard card) {
        hibernate.persist(card);
    }
}