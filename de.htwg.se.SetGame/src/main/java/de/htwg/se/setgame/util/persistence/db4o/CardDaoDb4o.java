package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ObjectContainer;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.persistence.CardDao;

/**
 * @author Philipp Daniels
 */
public class CardDaoDb4o extends Db4oBase implements CardDao {

    protected CardDaoDb4o(ObjectContainer db, ModelFactory factory) {
        super(db, factory);
    }

    @Override
    public ICard create() {
        return getFactory().createCard();
    }

    @Override
    public void add(ICard card) {
        store(card);
    }

    @Override
    public void update(ICard card) {
        store(card);
    }
}
