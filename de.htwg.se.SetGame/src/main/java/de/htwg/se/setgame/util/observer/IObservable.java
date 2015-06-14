package de.htwg.se.setgame.util.observer;

/**
 * Interface implementation of the Observable part of Observer-Pattern.
 */
public interface IObservable {

	/**
	 * Add a new IObserver to notification list.
	 * @param s IObserver instance.
	 */
	void addObserver(IObserver s);

	/**
	 * Remove IObserver instance of the notification list.
	 * @param s IObserver instance.
	 */
	void removeObserver(IObserver s);

	/**
	 * Remove all instances of the notification list.
	 */
	void removeAllObservers();

	/**
	 * Call all IObserver instances without an Event instance.
	 */
	void notifyObservers();

	/**
	 * Call all IObserver instances with the given Event instance.
	 * @param e Event instance.
	 */
	void notifyObservers(Event e);
}
