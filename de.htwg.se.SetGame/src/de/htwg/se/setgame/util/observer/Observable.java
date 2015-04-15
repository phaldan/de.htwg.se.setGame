package de.htwg.se.setgame.util.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement IObservable with ArrayList.
 * @author Philipp
 */
public abstract class Observable implements IObservable {

	private List<IObserver> subscribers = new ArrayList<>();

	@Override
	public void addObserver(IObserver s) {
		subscribers.add(s);
	}

	@Override
	public void removeObserver(IObserver s) {
		subscribers.remove(s);
	}

	@Override
	public void removeAllObservers() {
		subscribers.clear();
	}

	@Override
	public void notifyObservers() {
		notifyObservers(null);
	}

	@Override
	public void notifyObservers(Event e) {
		for (IObserver o: subscribers) {
			o.update(e);
		}
	}

	/**
	 * @return Return number of IObserver instances
	 */
	public int countObservers() {
		return subscribers.size();
	}
}
