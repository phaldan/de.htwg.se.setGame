package de.htwg.se.setgame.model;

import java.util.List;

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
	 * @return get unused cards
	 */
	List<ICard> getUnusedCards();

	/**
	 * @param size set size of field
	 */
	void setSize(int size);

}