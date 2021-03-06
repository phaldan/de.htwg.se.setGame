package de.htwg.se.setgame.controller;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.model.ISet;
import de.htwg.se.setgame.util.observer.Observable;

import java.util.*;

/**
 * @author Philipp Daniels
 */
public class ControllerDummy extends Observable implements IController {

    @Override
    public void add(ISet set, IPlayer player) {

    }

    @Override
    public ISet createSet() {
        return null;
    }

    @Override
    public ISet getSet() {
        return null;
    }

    @Override
    public void newGame() {

    }

    @Override
    public void setFieldSize(int size) {

    }

    @Override
    public Map<Integer, ICard> getCardsAndTheIndexOfCardInField() {
        return new TreeMap<>();
    }

    @Override
    public void exit() {

    }

    @Override
    public List<IPlayer> getPlayers() {
        return new LinkedList<>();
    }

    @Override
    public void registerPlayer(String name) {

    }

    @Override
    public Collection<String> getCpus() {
        return null;
    }

    @Override
    public String getActiveCpu() {
        return null;
    }

    @Override
    public void setCpu(String name) {

    }
}
