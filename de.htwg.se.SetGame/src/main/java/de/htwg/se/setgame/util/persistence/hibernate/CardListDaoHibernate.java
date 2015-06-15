package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.util.persistence.CardListDao;
import de.htwg.se.setgame.util.persistence.hibernate.pojo.CardListHibernate;
import org.hibernate.criterion.Restrictions;

/**
 * @author Philipp Daniels
 */
public class CardListDaoHibernate implements CardListDao {

    private HibernateBase db;

    protected CardListDaoHibernate(HibernateBase db) {
        this.db = db;
    }

    @Override
    public ICardList create() {
        return new CardListHibernate();
    }

    @Override
    public ICardList getByGame(IGame game) {
        ICardList entity = (ICardList) db.getCriteria(CardListHibernate.class)
                .add(Restrictions.eq("game", game))
                .createAlias("game", "g")
                .uniqueResult();
        db.close();
        return entity;
    }

    @Override
    public void add(ICardList list) {
        db.persist(list);
    }

    @Override
    public void update(ICardList list) {
        db.persist(list);
    }
}
