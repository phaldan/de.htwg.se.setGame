package de.htwg.se.setgame.controller.impl;

import com.google.inject.Inject;
import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.controller.event.AddEvent;
import de.htwg.se.setgame.controller.event.CloseEvent;
import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.util.observer.Observable;

import java.util.*;

/**
 * @author raina
 */
public class SetController extends Observable implements IController {

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
    private List<IPlayer> players = new LinkedList<>();


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
        init();
    }

    private void init() {
        fieldCards = factory.createCardList();

        players.add(createPlayer("Player One"));
        players.add(createPlayer("Player Two"));
    }

    private IPlayer createPlayer(String name) {
        IPlayer player = factory.createPlayer();
        player.setName(name);
        return player;
    }

    @Override
    public void newGame() {
        unusedCards = generator.generate();
        clearField();
        setFieldSize(size);
    }

    private void clearField() {
        for (ICard card: fieldCards.getCards()) {
            fieldCards.getCards().remove(card);
        }
    }

    @Override
    public void setFieldSize(int size) {
        this.size = (size > MIN_FIELD_SIZE) ? size : MIN_FIELD_SIZE;
        resize.resize(fieldCards, unusedCards, this.size);
    }

    @Override
    public void add(ISet set, IPlayer player) {
        if (validatePlayer(player) && checker.isSet(set)) {
            fieldCards.getCards().remove(set.getFirst());
            fieldCards.getCards().remove(set.getSecond());
            fieldCards.getCards().remove(set.getThird());
            setFieldSize(size);
            increasePlayerScore(player);
            notifyObservers(new AddEvent());
        }
    }

    private boolean validatePlayer(IPlayer player) {
        return player == null || getPlayers().contains(player);
    }

    private void increasePlayerScore(IPlayer player) {
        if  (player != null) {
            player.setScore(player.getScore() + 1);
        }
    }

    @Override
    public ISet createSet() {
        return factory.createSet();
    }

    @Override
    public ISet getSet() {
        return cardSet.getSet(new LinkedList<>(fieldCards.getCards()));
    }

    @Override
    public Map<Integer, ICard> getCardsAndTheIndexOfCardInField() {
        Map<Integer, ICard> map = new TreeMap<>();
        int i = 0;
        for (ICard card: fieldCards.getCards()) {
            map.put(i, card);
            i++;
        }
        return map;
    }

    @Override
    public void exit() {
        notifyObservers(new CloseEvent());
    }

    @Override
    public List<IPlayer> getPlayers() {
        return players;
    }
}
