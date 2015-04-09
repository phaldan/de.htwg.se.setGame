package de.htwg.se.setgame.persistence.db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IPack;
import de.htwg.se.setgame.persistence.IPackDAO;

import java.util.List;

/**
 * Created by Pavan on 09.04.2015.
 */
public class PackDb4oDAO implements IPackDAO {

    private ObjectContainer db;

    public PackDb4oDAO(){
        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
                "pack.data");
    }


    /*
     * readPack() retrieves all Packs
     */
        @Override
    public List<IPack> readAllPacks() {
        return db.query(IPack.class);
    }

    /*
 * readPack() retrieves all Packs
 */
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
    public void deletePack(final IPack pack) {db.delete(pack);}

    @Override
    public boolean containsCard(String color, String form, String panelFilling) {
        return false;
    }

    @Override
    public boolean containsCard(final ICard card) {
        final List<IPack> packs = db.query(new Predicate<IPack>() {

            if (packs.size() > 0) {
                @Override
                public boolean match(IPack pack) {
                    //for(IPack a : packs){a.getPack().contains(card);}
                    {pack.getPack().contains(card);}
                })
            }
        }
    return false;
    }

    public void closeDb() {
        db.close();
    }
}