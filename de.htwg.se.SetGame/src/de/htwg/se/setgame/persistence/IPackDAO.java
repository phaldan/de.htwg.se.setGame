package de.htwg.se.setgame.persistence;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IPack;

import java.util.List;

/**
 * Created by Pavan on 09.04.2015.
 */
public interface IPackDAO {

    List<IPack> readAllPacks ();
    void storePack(IPack pack);
    //void updatePack(IPack pack);//updated() is not needed at all
    void deletePack(final IPack pack);
    boolean containsCard(String color, String form, String panelFilling);
    IPack readFirstPack();

}
