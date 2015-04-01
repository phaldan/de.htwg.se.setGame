package de.htwg.se.setgame.model;

import java.util.List;
import java.util.Map;

public interface IField {

	/**
	 * Initiate field.
	 */
	void startUp();

	 /**
	 * @param cardOne card set
	 * @param cardTwo card set
	 * @param cardThree card set
	 */
	void foundSet(ICard cardOne, ICard cardTwo, ICard cardThree);

	/**
	 * @return cardsInField
	 */
	List<ICard> getCardsInField();

	/**
	 * @param list change cards in field
	 */
	void changeCards(List<ICard> list);

	/**
	 * @return get unused cards
	 */
	List<ICard> getUnusedCards();

	/**
	 * @return size of field
	 */
	int getSizeofField();

	/**
	 * @return all Cards in game
	 */
	List<ICard> getAllCardsInGame();

	/**
	 * @return index and cards in game
	 */
	Map<Integer, ICard> getCardInFieldGame();

	/**
	 *  reset everything
	 */
	void clear();

	/**
	 * @param size set size of field
	 */
	void setSizeOfField(int size);

}