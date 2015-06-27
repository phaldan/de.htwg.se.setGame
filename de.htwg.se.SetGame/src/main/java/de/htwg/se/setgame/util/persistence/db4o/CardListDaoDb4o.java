package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.util.persistence.CardListDao;

import java.util.List;

/**
 * @author Philipp Daniels
 */
public class CardListDaoDb4o extends Db4oBase implements CardListDao {

    protected CardListDaoDb4o(ObjectContainer db, ModelFactory factory) {
        super(db, factory);
    }

    @Override
    public ICardList create() {
        return getFactory().createCardList();
    }

    @Override
    public ICardList getByGame(final IGame game) {
        List<ICardList> list = getDb().query(new Predicate<ICardList>() {

            @Override
            public boolean match(ICardList cardList) {
                return cardList.getGame().equals(game);
            }
        });

        return (list == null || list.isEmpty()) ? null: list.get(0);
    }

    @Override
    public void add(ICardList list) {
        store(list.getGame());
    }

    @Override
    public void update(ICardList list) {
        store(list.getGame());
    }
}
