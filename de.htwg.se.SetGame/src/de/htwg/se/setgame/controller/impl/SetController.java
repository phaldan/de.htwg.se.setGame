package de.htwg.se.setgame.controller.impl;

import com.google.inject.Inject;
import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.controller.event.CloseEvent;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IField;
import de.htwg.se.setgame.model.ISet;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.util.observer.Observable;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author raina
 */
public class SetController extends Observable implements IController {

    private ModelFactory factory;
    private IField field;
    private SetChecker checker;
    private CardSet cardSet;
    private static final int PLAYER_ONE = 1;
    private static final int PLAYER_TWO = 2;
    private int playerOneCounter;
    private int playerTwoCounter;

    /**
     * Logic Construct make for the game a new field with a new pack!!!
     *
     * @param factory Instance of ModelFactory
     */
    @Inject
    public SetController(ModelFactory factory) {
        this(factory, new SetChecker());

    }

    /**
     * @param factory Instance of ModelFactory
     * @param checker Instance of SetChecker
     */
    protected SetController(ModelFactory factory, SetChecker checker) {
        this(factory, checker, new CardSet(factory, checker));
    }

    /**
     * @param factory Instance of ModelFactory
     * @param checker Instance of SetChecker
     * @param cardSet Instance of CardSet
     */
    protected SetController(ModelFactory factory, SetChecker checker, CardSet cardSet) {
        this.factory = factory;
        this.checker = checker;
        this.cardSet = cardSet;
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

    @Override
    public void setFieldSize(int size) {
        field.setSize(size);
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
        return cardSet.getSet(field.getCardsInField()).getAll();
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
        notifyObservers(new CloseEvent());
    }
}
