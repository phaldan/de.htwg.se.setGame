package de.htwg.se.setgame.util.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement IObservable with ArrayList.
 */
public abstract class Observable implements IObservable {

	private List<IObserver> subscribers = new ArrayList<>();

	public void addObserver(IObserver s) {
		subscribers.add(s);
	}

	public void removeObserver(IObserver s) {
		subscribers.remove(s);
	}

	public void removeAllObservers() {
		subscribers.clear();
	}

	public void notifyObservers() {
		notifyObservers(null);
	}

	public void notifyObservers(Event e) {
		for (IObserver o: subscribers) {
			o.update(e);
		}
	}

	public int countObservers() {
		return subscribers.size();
	}
}
