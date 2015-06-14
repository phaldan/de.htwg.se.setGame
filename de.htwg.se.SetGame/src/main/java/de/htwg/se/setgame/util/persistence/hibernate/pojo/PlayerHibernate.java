package de.htwg.se.setgame.util.persistence.hibernate.pojo;

import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.impl.Player;

import javax.persistence.*;

/**
 * @author Philipp Daniels
 */
@Entity
@Table
public class PlayerHibernate extends Player {

    @Override
    @Id
    @GeneratedValue
    public Integer getId() {
        return super.getId();
    }

    @Override
    @Column
    public String getName() {
        return super.getName();
    }

    @Override
    @Column
    public int getScore() {
        return super.getScore();
    }

    @Override
    @ManyToOne(targetEntity = GameHibernate.class)
    public IGame getGame() {
        return super.getGame();
    }
}
