package de.htwg.se.setgame.controller.impl;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.inject.Inject;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IField;
import de.htwg.se.setgame.model.IPack;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.util.observer.Observable;

/**
 * @author raina
 */
public class SetController extends Observable implements IController {

	private ModelFactory factory;
	private IField field;
	private IPack pack;
	private static final int NUMBER_OF_SET_CARDS = 3;
	private static final int PLAYER_ONE = 1;
	private static final int PLAYER_TWO = 2;
	private int playerOneCounter;
	private int playerTwoCounter;

	/**
	 * Logic Construct make for the game a new field with a new pack!!!
	 */
	@Inject
	public SetController(ModelFactory factory) {
		this.factory = factory;
		pack = factory.createPack();
		reset();
	}

	private void reset() {
		field = factory.createField();
		playerOneCounter = 0;
		playerTwoCounter = 0;
		notifyObservers();
	}

	@Override
	public void newGame() {
		reset();
	}

	private boolean isASet(ICard cardOne, ICard cardTwo, ICard cardThree) {
		int size = field.getUnusedCards().size();
		field.foundSet(cardOne, cardTwo, cardThree);
		return size > field.getUnusedCards().size();
	}

	@Override
	public void setFieldSize(int size){
		field.setSize(size);
	}

	private boolean proveColor(ICard cardOne, ICard cardTwo, ICard cardThree) {
		return proveString(cardOne.getColor(), cardTwo.getColor(),
				cardThree.getColor());
	}

	private boolean proveNumberOfComponents(ICard cardOne, ICard cardTwo,
			ICard cardThree) {
		if (cardOne.getNumberOfComponents().equals(cardTwo.getNumberOfComponents())
				&& cardOne.getNumberOfComponents().equals(cardThree.getNumberOfComponents())) {
			return true;
		} else if (!cardOne.getNumberOfComponents().equals(cardTwo.getNumberOfComponents())
				&& !cardOne.getNumberOfComponents().equals(cardThree.getNumberOfComponents())
				&& !cardTwo.getNumberOfComponents().equals(cardThree.getNumberOfComponents())) {
			return true;
		}
		return false;
	}

	private boolean proveFilling(ICard cardOne, ICard cardTwo, ICard cardThree) {
		return proveString(cardOne.getPanelFilling(),
				cardTwo.getPanelFilling(), cardThree.getPanelFilling());
	}

	private boolean proveForm(ICard cardOne, ICard cardTwo, ICard cardThree) {
		return proveString(cardOne.getForm(), cardTwo.getForm(),
				cardThree.getForm());
	}

	private boolean proveString(String stringOne, String stringTwo,
			String stringThree) {
		if (stringOne.compareTo(stringTwo) == 0
				&& stringOne.compareTo(stringThree) == 0 && stringTwo.compareTo(stringThree) == 0) {
			return true;
		} else if (stringOne.compareTo(stringTwo) != 0
				&& stringOne.compareTo(stringThree) != 0
				&& stringTwo.compareTo(stringThree) != 0) {
			return true;
		}
		return false;
	}

	private boolean proveIfIsASet(ICard cardOne, ICard cardTwo, ICard cardThree) {
		return proveColor(cardOne, cardTwo, cardThree)
				&& proveFilling(cardOne, cardTwo, cardThree)
				&& proveNumberOfComponents(cardOne, cardTwo, cardThree)
				&& proveForm(cardOne, cardTwo, cardThree);
	}

	private List<ICard> getSet(List<ICard> list) {
		LinkedList<ICard> setList = new LinkedList<>();
		if (list.size() >= NUMBER_OF_SET_CARDS) {

			for (ICard cardOne : list) {
				for (ICard cardTwo : list) {
					if (!cardOne.equals(cardTwo)) {
						for (ICard cardThree : list) {

							if (proveIfIsASet(cardOne, cardTwo, cardThree)
									&& !cardThree.equals(cardOne)
									&& !(cardTwo.equals(cardThree))) {

								setList.add(cardOne);
								setList.add(cardTwo);
								setList.add(cardThree);
								return setList;
							}
						}
					}
				}
			}

		}

		return setList;
	}

	@Override
	public List<ICard> getCardinGame() {
		return this.field.getCardsInField();
	}

	@Override
	public IField getField() {
		return this.field;
	}

	@Override
	public void isASetForController(ICard cardOne, ICard cardTwo,
									ICard cardThree, int player) {
		if (isASet(cardOne, cardTwo, cardThree)) {
			if (SetController.PLAYER_ONE == player) {
				this.playerOneCounter = this.playerOneCounter + 1;
			} else if (SetController.PLAYER_TWO == player) {
				this.playerTwoCounter = this.playerTwoCounter + 1;

			}
			if (PLAYER_ONE == player || player == SetController.PLAYER_TWO || player >= 0) {
				notifyObservers();
			}
		}
	}

	@Override
	public boolean stillSetInGame() {
		return !getSetInField().isEmpty();
	}

	@Override
	public List<ICard> getSetInField() {
		return getSet(this.field.getCardsInField());
	}

	@Override
	public int getPlayerOnePoints() {
		return this.playerOneCounter;
	}

	@Override
	public int getPlayerTwoPoints() {
		return this.playerTwoCounter;
	}

	@Override
	public int getPlayerOne() {
		return SetController.PLAYER_ONE;
	}

	@Override
	public int getPlayerTwo() {
		return SetController.PLAYER_TWO;
	}

	@Override
	public Map<Integer, ICard> getCardsAndTheIndexOfCardInField() {
		Map<Integer, ICard> map = new TreeMap<>();
		for (int i = 0; i < field.getCardsInField().size(); i++) {
			map.put(i, field.getCardsInField().get(i));
		}
		return map;
	}

	@Override
	public ICard getFirstInSet() {
		LinkedList<ICard> list = new LinkedList<>(getSetInField());
		return list.peekFirst();
	}

	@Override
	public void exit() {

	}
}
