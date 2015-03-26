package de.htwg.se.setgame.util.observer;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Philipp Daniels
 */
public class ObservableTest {

    private class ObservableImpl extends Observable {
    }

    private class ObserverMock implements IObserver {

        Event event;

        @Override
        public void update(Event e) {
            event = e;
        }
    }

    private class EventImpl extends Event {
    }


    private Observable target;

    @Before
    public void setUp() {
        target = new ObservableImpl();
    }

    @Test
    public void countObservers_successEmpty() {
        assertEquals(0, target.countObservers());
    }

    @Test
    public void removeObserver_successEmpty() {
        target.removeObserver(new ObserverMock());
        assertEquals(0, target.countObservers());
    }

    @Test
    public void removeAllObservers_successEmpty() {
        target.removeAllObservers();
        assertEquals(0, target.countObservers());
    }

    @Test
    public void addObserver_success() {
        target.addObserver(new ObserverMock());
        assertEquals(1, target.countObservers());
    }

    @Test
    public void removeAllObservers_successWithSingleObserver() {
        target.addObserver(new ObserverMock());
        target.removeAllObservers();
        assertEquals(0, target.countObservers());
    }

    @Test
    public void removeObserver_successWithSingleObserver() {
        ObserverMock o = new ObserverMock();
        target.addObserver(o);
        target.removeObserver(o);
        assertEquals(0, target.countObservers());
    }

    @Test
    public void removeObserver_successWithNewObserver() {
        target.addObserver(new ObserverMock());
        target.removeObserver(new ObserverMock());
        assertEquals(1, target.countObservers());
    }

    @Test
    public void notifyObservers_successWithoutEvent() {
        ObserverMock o = new ObserverMock();
        o.event = new EventImpl();
        target.addObserver(o);

        target.notifyObservers();

        assertNull(o.event);
    }

    @Test
    public void notifyObservers_successSingleObserver() {
        ObserverMock o = new ObserverMock();
        target.addObserver(o);

        EventImpl e = new EventImpl();
        target.notifyObservers(e);

        assertSame(e, o.event);
    }

    @Test
    public void notifyObservers_successMultipleObserver() {
        ObserverMock o1 = new ObserverMock();
        target.addObserver(o1);
        ObserverMock o2 = new ObserverMock();
        target.addObserver(o2);

        EventImpl e = new EventImpl();
        target.notifyObservers(e);

        assertSame(e, o1.event);
        assertSame(e, o2.event);
    }

}
