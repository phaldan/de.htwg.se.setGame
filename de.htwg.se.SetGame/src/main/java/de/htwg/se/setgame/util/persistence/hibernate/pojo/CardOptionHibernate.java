package de.htwg.se.setgame.util.persistence.hibernate.pojo;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IOptionValue;
import de.htwg.se.setgame.model.impl.CardOption;

import javax.persistence.*;

/**
 * @author Philipp Daniels
 */
@Entity
@Table(name = "card_option")
public class CardOptionHibernate extends CardOption {

    @Override
    @Id
    @GeneratedValue
    public Integer getId() {
        return super.getId();
    }

    @Override
    @ManyToOne(targetEntity = CardHibernate.class)
    public ICard getCard() {
        return super.getCard();
    }

    @Override
    @ManyToOne(targetEntity = OptionValueHibernate.class)
    public IOptionValue getOption() {
        return super.getOption();
    }
}
