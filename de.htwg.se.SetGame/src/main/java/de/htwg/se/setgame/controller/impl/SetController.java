package de.htwg.se.setgame.controller.impl;

import com.google.inject.Inject;
import de.htwg.se.setgame.controller.CpuPlayer;
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
    public static final int MIN_FIELD_SIZE = 3;

    private ModelFactory factory;
    private DaoManager dao;
    private Map<String, CpuPlayer> cpuPlayers = new TreeMap<>();
    private SetChecker checker;
    private CardSet cardSet;
    private GameCreator gameCreator;
    private IGame game;
    private int size = INITIAL_FIELD_SIZE;

    /**
     * @param factory Instance of ModelFactory
     */
    @Inject
    public SetController(ModelFactory factory, DaoManager dao, Set<CpuPlayer> cpuPlayers) {
        this.factory = factory;
        this.dao = dao;

        this.checker = new SetChecker();
        this.cardSet = new CardSet(factory, checker);
        this.gameCreator = new GameCreator(dao, cardSet);

        initiateCpuPlayer(cpuPlayers);
    }

    private void initiateCpuPlayer(Set<CpuPlayer> cpuPlayers) {
        for (CpuPlayer cpu: cpuPlayers) {
            this.cpuPlayers.put(cpu.getLevel().toString(), cpu);
        }
    }

    @Override
    public void newGame() {
        if (game != null && !getPlayers().isEmpty()) {
            game = gameCreator.create(game.getPlayers(), size);
            setFieldSize(size);
            notifyObservers();
        }
    }

    @Override
    public void setFieldSize(int size) {
        this.size = gameCreator.setFieldSize(game, size);
    }

    @Override
    public void add(ISet set, IPlayer player) {
        if (game != null && validatePlayer(player) && checker.isSet(set)) {
            remove(set.getFirst());
            remove(set.getSecond());
            remove(set.getThird());
            setFieldSize(size);
            increasePlayerScore(player);
            notifyObservers(new AddEvent());
        }
    }

    private void remove(ICard card) {
        getGame().getFieldCardList().getCards().remove(card);
        card.setCardList(null);
        dao.getCard().update(card);
    }

    private boolean validatePlayer(IPlayer player) {
        return player == null || getPlayers().contains(player);
    }

    private void increasePlayerScore(IPlayer player) {
        if  (player != null) {
            player.setScore(player.getScore() + 1);
            dao.getPlayer().update(player);
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
        dao.exit();
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
        game = gameCreator.create(game, player, size);
        if (game.getCpu() != null) {
            cpuPlayers.get(game.getCpu()).activate(this);
        }
        notifyObservers();
    }

    @Override
    public Collection<String> getCpus() {
        return new LinkedList<>(cpuPlayers.keySet());
    }

    @Override
    public String getActiveCpu() {
        return (game == null) ? null: game.getCpu();
    }

    @Override
    public void setCpu(String name) {
        if (game != null) {
            if (game.getCpu() != null) {
                cpuPlayers.get(game.getCpu()).disable(this);
            }

            game.setCpu(name);
            dao.getGame().update(game);

            if (game.getCpu() != null) {
                cpuPlayers.get(name).activate(this);
            }
        }
    }

    private IPlayer getPlayer(String name) {
        PlayerDao playerDao = dao.getPlayer();
        IPlayer player = playerDao.getByName(name);
        if (player == null) {
            player = playerDao.create();
            player.setName(name);
            playerDao.add(player);
        }
        return player;
    }

    protected IGame getGame() {
        return game;
    }

}
