package de.htwg.se.setgame.model;

import java.util.List;
import java.util.Map;

public interface IField {

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.model.IField#startUp()
	 */
	void startUp();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.model.IField#foundSet(setgame.model.Card,
	 * setgame.model.Card, setgame.model.Card)
	 */
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
	 * @param liste change cards in field
	 */
	void changeCards(List<ICard> liste);

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