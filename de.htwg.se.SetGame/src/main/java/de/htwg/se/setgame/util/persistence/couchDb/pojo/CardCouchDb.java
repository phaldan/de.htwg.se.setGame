package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.ICardOption;
import de.htwg.se.setgame.model.impl.Card;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

import java.util.Set;

/**
 * @author Philipp Daniels
 */
public class CardCouchDb extends Card {

    @Override
    @JsonBackReference
    public ICardList getCardList() {
        return super.getCardList();
    }

    @Override
    @JsonManagedReference
    public Set<ICardOption> getCardOptions() {
        return super.getCardOptions();
    }
}
