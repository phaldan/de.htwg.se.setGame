package de.htwg.se.setgame.util.persistence.hibernate.pojo;

import de.htwg.se.setgame.model.IOptionValue;
import de.htwg.se.setgame.model.impl.Option;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Philipp Daniels
 */
@Entity
@Table(name = "option")
public class OptionHibernate extends Option {

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
    @OneToMany(targetEntity = OptionValueHibernate.class, mappedBy = "option")
    public Set<IOptionValue> getOptionValues() {
        return super.getOptionValues();
    }
}
