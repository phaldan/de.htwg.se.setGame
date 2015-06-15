package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ObjectSet;
import com.db4o.ext.ExtObjectSet;

import java.util.LinkedList;

/**
 * @author Philipp Daniels
 */
public class ObjectSetDummy<T> extends LinkedList<T> implements ObjectSet<T> {

    @Override
    public ExtObjectSet ext() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public void reset() {

    }
}
