package de.htwg.se.setgame.util.persistence.hibernate.pojo;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.ICardOption;
import de.htwg.se.setgame.model.impl.Card;

import javax.persistence.*;
import java.util.Set;

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
    @ManyToOne(targetEntity = CardListHibernate.class)
    public ICardList getCardList() {
        return super.getCardList();
    }

    @Override
    @OneToMany(targetEntity = CardOptionHibernate.class, mappedBy = "card")
    public Set<ICardOption> getCardOptions() {
        return super.getCardOptions();
    }
}
