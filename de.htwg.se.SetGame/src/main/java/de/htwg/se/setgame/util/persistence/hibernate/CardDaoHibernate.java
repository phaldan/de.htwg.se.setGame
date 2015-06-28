package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.persistence.CardDao;
import de.htwg.se.setgame.util.persistence.hibernate.pojo.CardHibernate;
import org.apache.log4j.Logger;

/**
 * @author Philipp Daniels
 */
public class CardDaoHibernate implements CardDao {

    private static final Logger LOGGER = Logger.getLogger(CardDaoHibernate.class);

    private HibernateBase hibernate;

    protected CardDaoHibernate(HibernateBase hibernate) {
        this.hibernate = hibernate;
    }

    @Override
    public ICard create() {
        return new CardHibernate();
    }

    @Override
    public void add(ICard card) {
        hibernate.persist(card);
        LOGGER.debug("Add new: " + card.getId());
    }

    @Override
    public void update(ICard card) {
        hibernate.persist(card);
        LOGGER.debug("Update existing: " + card.getId());
    }
}
