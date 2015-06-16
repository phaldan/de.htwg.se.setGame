package de.htwg.se.setgame.util.persistence.couchDb;

import de.htwg.se.setgame.util.persistence.*;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

import java.net.MalformedURLException;

/**
 * @author Philipp Daniels
 */
public class CouchDbManager implements DaoManager {

    protected static final String DATABASE = "de-htwg-se-setgame2";

    protected CouchDbConnector db;

    private static CouchDbConnector create() throws MalformedURLException {
        HttpClient client = new StdHttpClient.Builder()
                .url("http://lenny2.in.htwg-konstanz.de:5984")
                .build();
        CouchDbInstance dbInstance = new StdCouchDbInstance(client);
        return dbInstance.createConnector(DATABASE, true);
    }

    /**
     * @throws MalformedURLException
     */
    public CouchDbManager() throws MalformedURLException {
        this(create());
    }

    protected CouchDbManager(CouchDbConnector db) {
        this.db = db;
    }

    @Override
    public CardDao getCard() {
        return new CardDaoCouchDb();
    }

    @Override
    public CardListDao getCardList() {
        return new CardListDaoCouchDb();
    }

    @Override
    public PlayerDao getPlayer() {
        return new PlayerDaoCouchDb();
    }

    @Override
    public GameDao getGame() {
        return new GameDaoCouchDb(db);
    }
}
