package de.htwg.se.setgame.model;

/**
 * @author Philipp Daniels
 */
public interface ModelFactory {

    IField createField();

    IPack createPack();
}
