package de.htwg.se.setgame.util.persistence.couchDb.pojo;

import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.impl.Player;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Philipp Daniels
 */
public class PlayerCouchDb extends Player {

    @Override
    @JsonBackReference
    public IGame getGame() {
        return super.getGame();
    }

    @Override
    public int getScore() {
        return super.getScore();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
