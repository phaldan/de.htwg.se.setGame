package de.htwg.se.setgame.util.persistence.hibernate.pojo;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.impl.CardList;

import javax.persistence.*;
import java.util.List;

/**
 * @author Philipp Daniels
 */
@Entity
@Table
public class CardListHibernate extends CardList {

    @Override
    @Id
    public Integer getId() {
        return super.getId();
    }

    @Override
    @OneToMany(targetEntity = CardHibernate.class)
    public List<ICard> getCards() {
        return super.getCards();
    }

    @Override
    @OneToOne(targetEntity = GameHibernate.class)
    public IGame getGame() {
        return super.getGame();
    }
}
