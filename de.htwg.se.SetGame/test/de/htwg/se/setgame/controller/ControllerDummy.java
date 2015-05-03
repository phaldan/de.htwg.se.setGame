package de.htwg.se.setgame.controller;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.model.ISet;
import de.htwg.se.setgame.util.observer.Observable;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Philipp Daniels
 */
public class ControllerDummy extends Observable implements IController {

    @Override
    public void isASetForController(ICard cardOne, ICard cardTwo, ICard cardThree, int player) {

    }

    @Override
    public void add(ISet set, IPlayer player) {

    }

    @Override
    public ISet createSet() {
        return null;
    }

    @Override
    public boolean stillSetInGame() {
        return false;
    }

    @Override
    public List<ICard> getSetInField() {
        return null;
    }

    @Override
    public int getPlayerOnePoints() {
        return 0;
    }

    @Override
    public int getPlayerTwoPoints() {
        return 0;
    }

    @Override
    public int getPlayerOne() {
        return 0;
    }

    @Override
    public int getPlayerTwo() {
        return 0;
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
    public ICard getFirstInSet() {
        return null;
    }

    @Override
    public void exit() {

    }

    @Override
    public List<IPlayer> getPlayers() {
        return new LinkedList<>();
    }
}
