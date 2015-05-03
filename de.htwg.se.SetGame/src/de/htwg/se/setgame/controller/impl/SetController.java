package de.htwg.se.setgame.controller.impl;

import com.google.inject.Inject;
import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.controller.event.CloseEvent;
import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.util.observer.Observable;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author raina
 */
public class SetController extends Observable implements IController {

    private static final int PLAYER_ONE = 1;
    private static final int PLAYER_TWO = 2;
    private static final int INITIAL_FIELD_SIZE = 12;
    private static final int MIN_FIELD_SIZE = 3;

    private ModelFactory factory;
    private SetChecker checker;
    private CardSet cardSet;
    private CardGenerator generator;
    private ICardList fieldCards;
    private ICardList unusedCards;
    private Resize resize;
    private int size = INITIAL_FIELD_SIZE;
    private int playerOneCounter = 0;
    private int playerTwoCounter = 0;

    /**
     * @param factory Instance of ModelFactory
     */
    @Inject
    public SetController(ModelFactory factory) {
        this.factory = factory;
        checker = new SetChecker();
        cardSet = new CardSet(factory, checker);
        generator = new CardGenerator(factory);
        resize = new Resize(cardSet);
        fieldCards = factory.createCardList();
    }

    @Override
    public void newGame() {
        unusedCards = generator.generate();
        clearField();
        setFieldSize(size);
    }

    private void clearField() {
        for (ICard card: fieldCards.getCards()) {
            fieldCards.removeCard(card);
        }
    }

    @Override
    public void setFieldSize(int size) {
        this.size = (size > MIN_FIELD_SIZE) ? size : MIN_FIELD_SIZE;
        resize.resize(fieldCards, unusedCards, this.size);
    }

    @Override
    public void isASetForController(ICard cardOne, ICard cardTwo,
                                    ICard cardThree, int player) {
        ISet set = factory.createSet();
        set.setFirst(cardOne);
        set.setSecond(cardTwo);
        set.setThird(cardThree);
        if (checker.isSet(set)) {
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
        ISet set = cardSet.getSet(fieldCards.getCards());
        return (set == null) ? new LinkedList<ICard>() : set.getAll();
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
        List<ICard> list = fieldCards.getCards();
        for (int i = 0; i < list.size(); i++) {
            map.put(i, list.get(i));
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
        notifyObservers(new CloseEvent());
    }

    @Override
    public List<IPlayer> getPlayers() {
        return null;
    }
}
