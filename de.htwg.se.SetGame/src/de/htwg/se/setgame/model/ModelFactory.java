package de.htwg.se.setgame.model;

/**
 * @author Philipp Daniels
 */
public interface ModelFactory {

    /**
     * @return Return new IField instance
     */
    IField createField();

    /**
     * @return Return new IPack instance
     */
    IPack createPack();

    /**
     * @return Return new ISet instance
     */
    ISet createSet();
}
