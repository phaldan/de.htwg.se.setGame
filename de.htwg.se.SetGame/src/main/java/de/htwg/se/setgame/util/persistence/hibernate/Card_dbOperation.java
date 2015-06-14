package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.persistence.CardDao;
import org.hibernate.SessionFactory;


public class Card_dbOperation extends HibernateBase implements CardDao {

    protected Card_dbOperation(SessionFactory factory) {
        super(factory);
    }

    @Override
    public ICard create() {
        return null;
    }

    @Override
    public void add(ICard card) {
        persist(card);
    }

    @Override
    public void update(ICard card) {
        persist(card);
    }
}
