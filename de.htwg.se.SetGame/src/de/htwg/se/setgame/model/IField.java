package de.htwg.se.setgame.model;

import java.util.List;
import java.util.Map;

public interface IField {

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
	 * @return all Cards in game
	 */
	List<ICard> getAllCardsInGame();

	/**
	 * @return index and cards in game
	 */
	Map<Integer, ICard> getCardInFieldGame();

	/**
	 * @param size set size of field
	 */
	void setSize(int size);

}