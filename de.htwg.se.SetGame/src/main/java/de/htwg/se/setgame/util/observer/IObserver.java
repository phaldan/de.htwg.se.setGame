package de.htwg.se.setgame.util.observer;

/**
 * Interface implementation of the Observer part of Observer-Pattern.
 */
public interface IObserver {

	/**
	 * Called by Observable on notify call.
	 * @param e Event instance.
	 */
	void update(Event e);
}
