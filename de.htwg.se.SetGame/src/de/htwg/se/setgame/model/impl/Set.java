package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.ISet;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Philipp Daniels
 */
public class Set implements ISet {

    private ICard first;
    private ICard second;
    private ICard third;

    @Override
    public ICard getFirst() {
        return first;
    }

    @Override
    public void setFirst(ICard first) {
        this.first = first;
    }

    @Override
    public ICard getSecond() {
        return second;
    }

    @Override
    public void setSecond(ICard second) {
        this.second = second;
    }

    @Override
    public ICard getThird() {
        return third;
    }

    @Override
    public void setThird(ICard third) {
        this.third = third;
    }

    @Override
    public List<ICard> getAll() {
        List<ICard> list = new LinkedList<>();
        list.add(first);
        list.add(second);
        list.add(third);
        return list;
    }
}
