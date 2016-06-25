package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.impl.Card;
import org.codehaus.jackson.annotate.JsonBackReference;

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
    public Integer getNumberOfComponents() {
        return super.getNumberOfComponents();
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public String getForm() {
        return super.getForm();
    }

    @Override
    public String getPanelFilling() {
        return super.getPanelFilling();
    }
}
