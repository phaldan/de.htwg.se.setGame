package de.htwg.se.setgame.util.persistence.hibernate.pojo;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.impl.Card;

import javax.persistence.*;

/**
 * @author Philipp Daniels
 */
@Entity
@Table(name = "card")
public class CardHibernate extends Card {

    @Override
    @Id
    @GeneratedValue
    public Integer getId() {
        return super.getId();
    }

    @Override
    @Column
    public String getPanelFilling() {
        return super.getPanelFilling();
    }

    @Override
    @Column
    public String getForm() {
        return super.getForm();
    }

    @Override
    @Column
    public String getColor() {
        return super.getColor();
    }

    @Override
    @Column
    public Integer getNumberOfComponents() {
        return super.getNumberOfComponents();
    }

    @Override
    @ManyToOne(targetEntity = CardListHibernate.class)
    public ICardList getCardList() {
        return super.getCardList();
    }
}
