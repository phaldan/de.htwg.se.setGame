package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import de.htwg.se.setgame.model.IOptionValue;
import de.htwg.se.setgame.model.impl.Option;
import org.codehaus.jackson.annotate.JsonBackReference;

import java.util.Set;

/**
 * @author Philipp Daniels
 */
public class OptionCouchDb extends Option {

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    @JsonBackReference
    public Set<IOptionValue> getOptionValues() {
        return super.getOptionValues();
    }
}
