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

    private static final String DATABASE = "de-htwg-se-setgame2";

    private CouchDbConnector db;

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
        return new CardDaoCouchDb(db);
    }

    @Override
    public CardListDao getCardList() {
        return new CardListDaoCouchDb(db);
    }

    @Override
    public PlayerDao getPlayer() {
        return new PlayerDaoCouchDb(db);
    }

    @Override
    public GameDao getGame() {
        return new GameDaoCouchDb(db);
    }

    @Override
    public OptionDao getOption() {
        return new OptionDaoCouchDb(db);
    }

    @Override
    public OptionValueDao getOptionValue() {
        return new OptionValueDaoCouchDb(db);
    }

    @Override
    public CardOptionDao getCardOption() {
        return new CardOptionDaoCouchDb(db);
    }

    @Override
    public void exit() {
        db.getConnection().shutdown();
    }
}
