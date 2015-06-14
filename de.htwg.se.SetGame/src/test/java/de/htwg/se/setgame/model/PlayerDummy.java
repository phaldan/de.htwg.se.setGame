package de.htwg.se.setgame.model;

/**
 * @author Philipp Daniels
 */
public class PlayerDummy implements IPlayer {

    @Override
    public Integer getId() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public void setId(Integer id) {

    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setScore(int score) {

    }

    @Override
    public IGame getGame() {
        return null;
    }

    @Override
    public void setGame(IGame game) {

    }
}
