package de.htwg.se.setgame.persistence;

import de.htwg.se.setgame.model.IPack;

import java.util.List;

/**
 * @author Pavan
 */
public interface IPackDAO {

    /**
     * @return Return list of IPack instances
     */
    List<IPack> readAllPacks ();

    /**
     * @param pack Instance of IPack
     */
    void storePack(IPack pack);

    /**
     * @param pack Instance of IPack
     */
    void deletePack(IPack pack);

    /**
     * @param color Color of ICard
     * @param form Form of ICard
     * @param panelFilling Filling of ICard
     * @return Return true, when a ICard with this attributes exists.
     */
    boolean containsCard(String color, String form, String panelFilling);

    /**
     * @return Return first instance of IPack
     */
    IPack readFirstPack();

}
