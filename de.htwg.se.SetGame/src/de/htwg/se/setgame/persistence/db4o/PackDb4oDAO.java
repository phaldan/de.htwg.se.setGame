package de.htwg.se.setgame.persistence.db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import de.htwg.se.setgame.model.IPack;
import de.htwg.se.setgame.persistence.IPackDAO;

import java.util.List;

/**
 * @author Pavan
 */
public class PackDb4oDAO implements IPackDAO {

    private ObjectContainer db;

    /**
     * Default constructor
     */
    public PackDb4oDAO() {
        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "pack.data");
    }

    @Override
    public List<IPack> readAllPacks() {
        return db.query(IPack.class);
    }

    @Override
    public IPack readFirstPack() {
        List<IPack> results = db.query(IPack.class);
        return results.get(0);
    }

    @Override
    public void storePack(IPack pack) {
        db.store(pack);
    }

    @Override
    public void deletePack(IPack pack) {
        db.delete(pack);
    }

    @Override
    public boolean containsCard(String color, String form, String panelFilling) {
        return false;
    }

}