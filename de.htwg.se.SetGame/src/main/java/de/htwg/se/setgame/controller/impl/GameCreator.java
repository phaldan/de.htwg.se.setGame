package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.util.persistence.DaoManager;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author Philipp Daniels
 */
public class GameCreator {

    private DaoManager dao;

    protected GameCreator(DaoManager dao) {
        this.dao = dao;
    }

    public IGame create(List<IPlayer> list) {
        IGame game = createGame();
        for (IPlayer player: list) {
            addPlayer(game, player);
        }
        return game;
    }

    public IGame create(IGame game, IPlayer player) {
        if (game != null) {
            addPlayer(game, player);
        } else if (player.getGame() != null) {
            game = player.getGame();
        } else {
            game = createGame();
            addPlayer(game, player);
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
        return game;
    }

    private ICardList createCardList(IGame game) {
        ICardList cardList = dao.getCardList().create();
        cardList.setGame(game);
        dao.getCardList().add(cardList);
        return cardList;
    }
}
