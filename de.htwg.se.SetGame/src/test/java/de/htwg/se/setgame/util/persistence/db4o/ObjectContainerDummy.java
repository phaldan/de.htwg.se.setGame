package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.ExtObjectContainer;
import com.db4o.query.Predicate;
import com.db4o.query.Query;
import com.db4o.query.QueryComparator;

import java.util.Comparator;

/**
 * @author Philipp Daniels
 */
public class ObjectContainerDummy implements ObjectContainer {

    @Override
    public void activate(Object o, int i) throws Db4oIOException, DatabaseClosedException {

    }

    @Override
    public boolean close() throws Db4oIOException {
        return false;
    }

    @Override
    public void commit() throws Db4oIOException, DatabaseClosedException, DatabaseReadOnlyException {

    }

    @Override
    public void deactivate(Object o, int i) throws DatabaseClosedException {

    }

    @Override
    public void delete(Object o) throws Db4oIOException, DatabaseClosedException, DatabaseReadOnlyException {

    }

    @Override
    public ExtObjectContainer ext() {
        return null;
    }

    @Override
    public <T> ObjectSet<T> queryByExample(Object o) throws Db4oIOException, DatabaseClosedException {
        return null;
    }

    @Override
    public Query query() throws DatabaseClosedException {
        return null;
    }

    @Override
    public <TargetType> ObjectSet<TargetType> query(Class<TargetType> aClass) throws Db4oIOException, DatabaseClosedException {
        return null;
    }

    @Override
    public <TargetType> ObjectSet<TargetType> query(Predicate<TargetType> predicate) throws Db4oIOException, DatabaseClosedException {
        return null;
    }

    @Override
    public <TargetType> ObjectSet<TargetType> query(Predicate<TargetType> predicate, QueryComparator<TargetType> queryComparator) throws Db4oIOException, DatabaseClosedException {
        return null;
    }

    @Override
    public <TargetType> ObjectSet<TargetType> query(Predicate<TargetType> predicate, Comparator<TargetType> comparator) throws Db4oIOException, DatabaseClosedException {
        return null;
    }

    @Override
    public void rollback() throws Db4oIOException, DatabaseClosedException, DatabaseReadOnlyException {

    }

    @Override
    public void store(Object o) throws DatabaseClosedException, DatabaseReadOnlyException {

    }
}
