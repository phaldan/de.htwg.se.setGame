package de.htwg.se.setgame.database.couchDB;

import com.fourspaces.couchdb.Database;
import de.htwg.se.setgame.database.Hibernate.DaoManager_Operation;
import de.htwg.se.setgame.util.persistence.DaoManager;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Pavan on 08/06/2015.
 */
public class SetupDBTest extends TestCase {


    DaoManager daoManager;
    SetupDB setupDB;
    String dbName = "SetCouchBasic_dbTest";


    @Test
    public void testSetDatabaseSession() throws Exception{
        Database db = null;
        daoManager = new DaoManager_Operation();
        setupDB = daoManager.getCouchDB();
        db = (setupDB.setDatabaseSession(dbName.toLowerCase()));
        assertNotNull(db);
    }

}