package de.htwg.se.setgame.controller.impl;

import com.google.inject.Inject;
import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.controller.event.AddEvent;
import de.htwg.se.setgame.controller.event.CloseEvent;
import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.util.observer.Observable;
import de.htwg.se.setgame.util.persistence.DaoManager;
import de.htwg.se.setgame.util.persistence.PlayerDao;

import java.util.*;

/**
 * @author raina
 */
public class SetController extends Observable implements IController {

    private static final int INITIAL_FIELD_SIZE = 12;
    private static final int MIN_FIELD_SIZE = 3;

    private ModelFactory factory;
    private DaoManager dao;
    private SetChecker checker;
    private CardSet cardSet;
    private Resize resize;
    private GameCreator gameCreator;
    private IGame game;
    private int size = INITIAL_FIELD_SIZE;

    /**
     * @param factory Instance of ModelFactory
     */
    @Inject
    public SetController(ModelFactory factory, DaoManager dao) {
        this.factory = factory;
        this.dao = dao;

        checker = new SetChecker();
        cardSet = new CardSet(factory, checker);
        resize = new Resize(cardSet);
        gameCreator = new GameCreator(dao);
    }

    @Override
    public void newGame() {
        if (game != null) {
            game = gameCreator.create(game.getPlayers());
            setFieldSize(size);
        }
    }

    @Override
    public void setFieldSize(int size) {
        this.size = (size > MIN_FIELD_SIZE) ? size : MIN_FIELD_SIZE;
        resize.resize(game.getFieldCardList(), game.getUnusedCardList(), this.size);
    }

    @Override
    public void add(ISet set, IPlayer player) {
        if (game != null && validatePlayer(player) && checker.isSet(set)) {
            getFieldCards().remove(set.getFirst());
            getFieldCards().remove(set.getSecond());
            getFieldCards().remove(set.getThird());
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
        return cardSet.getSet(new LinkedList<>(getFieldCards()));
    }

    @Override
    public Map<Integer, ICard> getCardsAndTheIndexOfCardInField() {
        Map<Integer, ICard> map = new TreeMap<>();
        int i = 0;
        for (ICard card: getFieldCards()) {
            map.put(i, card);
            i++;
        }
        return map;
    }

    private Collection<ICard> getFieldCards() {
        return (game == null || game.getFieldCardList() == null) ? new LinkedList<ICard>() : game.getFieldCardList().getCards();
    }

    @Override
    public void exit() {
        notifyObservers(new CloseEvent());
    }

    @Override
    public List<IPlayer> getPlayers() {
        List<IPlayer> list = new LinkedList<>();
        if (game != null) {
            list.addAll(game.getPlayers());
        }
        return list;
    }

    @Override
    public void registerPlayer(String name) {
        IPlayer player = getPlayer(name);
        game = gameCreator.create(game, player);
        notifyObservers();
    }

    private IPlayer getPlayer(String name) {
        PlayerDao playerDao = dao.getPlayer();
        IPlayer player = playerDao.getByName(name);
        if (player == null) {
            player = dao.getPlayer().create();
            player.setName(name);
            playerDao.add(player);
        }
        return player;
    }

    protected IGame getGame() {
        return game;
    }

}
