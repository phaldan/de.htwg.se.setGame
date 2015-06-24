package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.util.persistence.DaoManager;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * @author Philipp Daniels
 */
public class GameCreator {

    private DaoManager dao;
    private CardGenerator generator;
    private Resize resize;

    protected GameCreator(DaoManager dao, CardSet cardSet) {
        this.dao = dao;
        this.generator = new CardGenerator(dao.getCard());
        this.resize = new Resize(cardSet, dao.getCard());
    }

    public IGame create(Collection<IPlayer> list, int size) {
        IGame game = createGame();
        for (IPlayer player: list) {
            addPlayer(game, player);
        }
        setFieldSize(game, size);
        return game;
    }

    public int setFieldSize(IGame game, int size) {
        int result = (size > SetController.MIN_FIELD_SIZE) ? size : SetController.MIN_FIELD_SIZE;
        resize.resize(game.getFieldCardList(), game.getUnusedCardList(), result);
        return result;
    }

    public IGame create(IGame game, IPlayer player, int size) {
        if (game != null) {
            addPlayer(game, player);
        } else if (player.getGame() != null) {
            game = player.getGame();
        } else {
            game = createGame();
            addPlayer(game, player);
            setFieldSize(game, size);

        }
        return game;
    }

    private void addPlayer(IGame game, IPlayer player) {
        if (!game.getPlayers().contains(player)) {
            game.getPlayers().add(player);
            player.setScore(0);
            player.setGame(game);
            dao.getPlayer().update(player);
        }
    }

    private IGame createGame() {
        IGame game = dao.getGame().create();
        game.setPlayers(new LinkedHashSet<IPlayer>());
        dao.getGame().add(game);

        game.setFieldCardList(createCardList(game));
        game.setUnusedCardList(createCardList(game));
        dao.getGame().update(game);

        generator.generate(game.getUnusedCardList());
        return game;
    }

    private ICardList createCardList(IGame game) {
        ICardList cardList = dao.getCardList().create();
        cardList.setGame(game);
        dao.getCardList().add(cardList);
        return cardList;
    }
}
