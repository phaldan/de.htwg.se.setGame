package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ObjectContainer;
import de.htwg.se.setgame.model.ModelFactory;
import org.apache.log4j.Logger;

/**
 * @author Philipp Daniels
 */
public abstract class Db4oBase {

    private static final Logger LOGGER = Logger.getLogger(Db4oBase.class.getName());

    private ModelFactory factory;
    private ObjectContainer db;

    protected Db4oBase(ObjectContainer db, ModelFactory factory) {
        this.db = db;
        this.factory = factory;
    }

    protected ModelFactory getFactory() {
        return factory;
    }

    protected ObjectContainer getDb() {
        return db;
    }

    protected void store(Object object) {
        try {
            getDb().store(object);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
