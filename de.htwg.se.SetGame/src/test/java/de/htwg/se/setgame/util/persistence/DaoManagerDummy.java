package de.htwg.se.setgame.util.persistence;

/**
 * @author Philipp Daniels
 */
public class DaoManagerDummy implements DaoManager {

    @Override
    public CardDao getCard() {
        return null;
    }

    @Override
    public CardListDao getCardList() {
        return null;
    }

    @Override
    public PlayerDao getPlayer() {
        return null;
    }

    @Override
    public GameDao getGame() {
        return null;
    }

    @Override
    public void exit() {

    }
}
