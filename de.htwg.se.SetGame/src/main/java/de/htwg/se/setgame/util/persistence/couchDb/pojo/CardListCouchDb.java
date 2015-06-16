package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import de.htwg.se.setgame.model.impl.CardList;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Philipp Daniels
 */
public class CardListCouchDb extends CardList {

    private String dbId;
    private String dbRev;

    @JsonProperty("_id")
    public String getDbId() {
        return dbId;
    }

    @JsonProperty("_id")
    public void setDbId(String dbId) {
        this.dbId = dbId;
    }

    @JsonProperty("_rev")
    public String getDbRev() {
        return dbRev;
    }

    @JsonProperty("_rev")
    public void setDbRev(String dbRev) {
        this.dbRev = dbRev;
    }
}
