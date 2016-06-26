package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.*;
import com.db4o.config.EmbeddedConfiguration;
import com.google.inject.Inject;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.util.persistence.*;

/**
 * @author Philipp Daniels
 */
public class Db4oManager implements DaoManager {

    private static final String FILENAME = "db4o.db";

    private ModelFactory factory;
    private ObjectContainer db;

    private static EmbeddedObjectContainer create() {
        EmbeddedConfiguration configuration = Db4oEmbedded.newConfiguration();
        return Db4oEmbedded.openFile(configuration, FILENAME);
    }

    /**
     * @param factory ModelFactory instance
     */
    @Inject
    public Db4oManager(ModelFactory factory) {
        this(factory, create());
    }

    protected Db4oManager(ModelFactory factory, ObjectContainer db) {
        this.factory = factory;
        this.db = db;
    }

    protected ObjectContainer getDb() {
        return db;
    }

    @Override
    public CardDao getCard() {
        return new CardDaoDb4o(db, factory);
    }

    @Override
    public CardListDao getCardList() {
        return new CardListDaoDb4o(db, factory);
    }

    @Override
    public PlayerDao getPlayer() {
        return new PlayerDaoDb4o(db, factory);
    }

    @Override
    public GameDao getGame() {
        return new GameDaoDb4o(db, factory);
    }

    @Override
    public OptionDao getOption() {
        return new OptionDaoDb4o(db, factory);
    }

    @Override
    public OptionValueDao getOptionValue() {
        return new OptionValueDaoDb4o(db, factory);
    }

    @Override
    public CardOptionDao getCardOption() {
        return new CardOptionDaoDb4o(db, factory);
    }

    @Override
    public void exit() {
        db.close();
    }
}
