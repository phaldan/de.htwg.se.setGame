package setgame.modell;

import java.util.List;
import java.util.Map;

import setgame.modell.impl.ACard;
import setgame.modell.impl.Card;

public interface IField {

	/* (non-Javadoc)
	 * @see setgame.modell.IField#startUp()
	 */
	public abstract void startUp();

	/* (non-Javadoc)
	 * @see setgame.modell.IField#foundSet(setgame.modell.Card, setgame.modell.Card, setgame.modell.Card)
	 */
	public abstract void foundSet(ACard cardOne, ACard cardTwo, ACard cardThree);

	/* (non-Javadoc)
	 * @see setgame.modell.IField#getCardsInField()
	 */
	public abstract List<Card> getCardsInField();

	/* (non-Javadoc)
	 * @see setgame.modell.IField#setSizeOfField(int, java.util.List)
	 */
	public abstract void setSizeOfField(int size, List<Card> removeThisCards);

	/* (non-Javadoc)
	 * @see setgame.modell.IField#changeCards(java.util.List)
	 */
	public abstract void changeCards(List<Card> liste);

	/* (non-Javadoc)
	 * @see setgame.modell.IField#getUnusedCards()
	 */
	public abstract List<Card> getUnusedCards();

	/* (non-Javadoc)
	 * @see setgame.modell.IField#getSizeofField()
	 */
	public abstract int getSizeofField();

	/* (non-Javadoc)
	 * @see setgame.modell.IField#getAllCardsInGame()
	 */
	public abstract List<Card> getAllCardsInGame();

	/* (non-Javadoc)
	 * @see setgame.modell.IField#getCardInFieldGame()
	 */
	public abstract Map<Integer, Card> getCardInFieldGame();

}