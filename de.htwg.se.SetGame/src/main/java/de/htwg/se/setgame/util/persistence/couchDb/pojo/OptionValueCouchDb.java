package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import de.htwg.se.setgame.model.IOption;
import de.htwg.se.setgame.model.impl.OptionValue;
import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 * @author Philipp Daniels
 */
public class OptionValueCouchDb extends OptionValue {

    @Override
    @JsonManagedReference
    public IOption getOption() {
        return super.getOption();
    }

    @Override
    public String getValue() {
        return super.getValue();
    }
}
