package de.htwg.se.setgame.util.persistence;

import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.model.impl.*;

/**
 * @author Philipp Daniels
 */
public class DaoManagerStub extends DaoManagerDummy {

    @Override
    public PlayerDao getPlayer() {
        return new PlayerDaoDummy() {

            @Override
            public IPlayer create() {
                return new Player();
            }
        };
    }

    @Override
    public GameDao getGame() {
        return new GameDaoDummy() {

            @Override
            public IGame create() {
                return new Game();
            }
        };
    }

    @Override
    public CardListDao getCardList() {
        return new CardListDaoDummy() {

            @Override
            public ICardList create() {
                return new CardList();
            }
        };
    }

    @Override
    public CardDao getCard() {
        return new CardDaoDummy() {

            @Override
            public ICard create() {
                return new Card();
            }
        };
    }

    @Override
    public CardOptionDao getCardOption() {
        return new CardOptionDaoDummy() {

            @Override
            public ICardOption create() {
                return new CardOption();
            }
        };
    }

    @Override
    public OptionDao getOption() {
        return new OptionDaoDummy() {

            @Override
            public IOption create() {
                return new Option();
            }
        };
    }

    @Override
    public OptionValueDao getOptionValue() {
        return new OptionValueDaoDummy() {

            @Override
            public IOptionValue create() {
                return new OptionValue();
            }
        };
    }
}