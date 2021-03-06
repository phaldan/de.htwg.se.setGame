package de.htwg.se.setgame.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.model.ISet;
import de.htwg.se.setgame.util.observer.IObservable;

/**
 * @author raina
 */
public interface IController extends IObservable {

	/**
	 * @param set Instance of ISet
	 * @param player Instance of IPlayer
	 */
	void add(ISet set, IPlayer player);

	/**
	 * @return Returns new instance of ISet
	 */
	ISet createSet();

	/**
	 * @return Return instance of ISet or null, when no valid set exists.
	 */
	ISet getSet();

	/**
	 * Reset game
	 */
	void newGame();

	/**
	 * @param size set size field
	 */
	void setFieldSize(int size);

	/**
	 * @return index and card in the index
	 */
	Map<Integer, ICard> getCardsAndTheIndexOfCardInField();

	/**
	 * Close game.
	 */
	void exit();

	/**
	 * @return Get list of IPlayer instances
	 */
	List<IPlayer> getPlayers();

	/**
	 * @param name Name of a player
	 * @return Returns true, when IPlayer has IGame instance
	 */
	void registerPlayer(String name);

	/**
	 * @return Return a list of available CpuLevel
	 */
	Collection<String> getCpus();

	/**
	 * @return Return null or name of CpuLevel
	 */
	String getActiveCpu();

	/**
	 * @param name Name of CpuLevel
	 */
	void setCpu(String name);
}