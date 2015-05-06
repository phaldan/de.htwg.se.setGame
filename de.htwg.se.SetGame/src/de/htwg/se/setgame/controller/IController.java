package de.htwg.se.setgame.controller;

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
	 * @return look trough the pack and see if still a set
	 */
	boolean stillSetInGame();

	/**
	 * @return return the set in field
	 */
	List<ICard> getSetInField();

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

}