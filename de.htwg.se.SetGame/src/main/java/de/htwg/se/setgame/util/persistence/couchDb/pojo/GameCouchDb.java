package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.model.impl.Game;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Set;

/**
 * @author Philipp Daniels
 */
public class GameCouchDb extends Game {

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

    @Override
    @JsonManagedReference
    @JsonProperty("fieldcardlist")
    public ICardList getFieldCardList() {
        return super.getFieldCardList();
    }

    @Override
    @JsonManagedReference
    @JsonProperty("unusedcardlist")
    public ICardList getUnusedCardList() {
        return super.getUnusedCardList();
    }

    @Override
    @JsonProperty("winner")
    public IPlayer getWinner() {
        return super.getWinner();
    }

    @Override
    @JsonManagedReference
    @JsonProperty("players")
    public Set<IPlayer> getPlayers() {
        return super.getPlayers();
    }

    @Override
    @JsonProperty("cpu")
    public String getCpu() {
        return super.getCpu();
    }
}
