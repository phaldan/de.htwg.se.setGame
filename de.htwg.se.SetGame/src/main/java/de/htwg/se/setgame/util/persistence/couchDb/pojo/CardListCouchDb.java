package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.impl.CardList;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

import java.util.Set;

/**
 * @author Philipp Daniels
 */
public class CardListCouchDb extends CardList {

    @Override
    @JsonBackReference
    public IGame getGame() {
        return super.getGame();
    }

    @Override
    @JsonManagedReference
    public Set<ICard> getCards() {
        return super.getCards();
    }
}
