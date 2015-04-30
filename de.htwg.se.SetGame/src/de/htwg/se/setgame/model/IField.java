package de.htwg.se.setgame.model;

import java.util.List;

/**
 * @author Philipp
 */
public interface IField {

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