package de.htwg.se.setgame.util.persistence.hibernate.pojo;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.model.impl.Game;

import javax.persistence.*;
import java.util.List;

/**
 * @author Philipp Daniels
 */
@Entity
@Table
public class GameHibernate extends Game {

    @Override
    @Id
    @GeneratedValue
    public Integer getId() {
        return super.getId();
    }

    @Override
    @OneToOne(targetEntity = CardListHibernate.class)
    public ICardList getFieldCardList() {
        return super.getFieldCardList();
    }

    @Override
    @OneToOne(targetEntity = CardListHibernate.class)
    public ICardList getUnusedCardList() {
        return super.getUnusedCardList();
    }

    @Override
    @OneToOne(targetEntity = PlayerHibernate.class)
    public IPlayer getWinner() {
        return super.getWinner();
    }

    @Override
    @OneToMany(targetEntity = PlayerHibernate.class)
    public List<IPlayer> getPlayers() {
        return super.getPlayers();
    }
}
