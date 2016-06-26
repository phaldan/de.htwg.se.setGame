package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.controller.CpuLevel;
import de.htwg.se.setgame.controller.CpuPlayer;
import de.htwg.se.setgame.controller.event.CloseEvent;
import de.htwg.se.setgame.controller.impl.cpu.CpuEasy;
import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.model.impl.*;
import de.htwg.se.setgame.util.observer.Event;
import de.htwg.se.setgame.util.observer.IObserver;
import de.htwg.se.setgame.util.persistence.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Philipp Daniels
 */
public class SetControllerTest {

    private class Player extends PlayerDummy {

        private int score = 0;

        @Override
        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public int getScore() {
            return score;
        }
    }

    private class Observer implements IObserver {
        @Override
        public void update(Event e) {
            event = e;
        }
    }

    private class SetStub extends SetDummy {

        private ICard one;
        private ICard two;
        private ICard three;

        public SetStub(ICard one, ICard two, ICard three) {
            this.one = one;
            this.two = two;
            this.three = three;
        }

        @Override
        public ICard getFirst() {
            return one;
        }

        @Override
        public ICard getSecond() {
            return two;
        }

        @Override
        public ICard getThird() {
            return three;
        }
    }

    private class ModelFactory extends ModelFactoryDummy {

        @Override
        public ISet createSet() {
            return new de.htwg.se.setgame.model.impl.Set();
        }
    }

    private class DaoManager extends DaoManagerDummy {

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

    private SetController target;
    private Event event;

    @Before
    public void setUp() {
        event = null;
        Set<CpuPlayer> cpus = new LinkedHashSet<>();
        cpus.add(new CpuEasy());
        target = new SetController(new ModelFactory(), new DaoManager(), cpus);
        target.addObserver(new Observer());
    }

    @Test
    public void exit_success() {
        target.exit();
        assertEquals(CloseEvent.class, event.getClass());
    }

    @Test
    public void getCardsAndTheIndexOfCardInField_success() {
        target.registerPlayer("player1");
        assertNotNull(target.getCardsAndTheIndexOfCardInField());
        assertFalse(target.getCardsAndTheIndexOfCardInField().isEmpty());
    }

    @Test
    public void newGame_success() {
        target.registerPlayer("player1");
        target.newGame();
    }

    @Test
    public void getPlayers_success() {
        assertNotNull(target.getPlayers());
        assertTrue(target.getPlayers().isEmpty());
    }

    @Test
    public void createSet_success() {
        assertNotNull(target.createSet());
    }

    @Test
    public void add_fail_playerNotContained() {
        ISet set = new SetDummy();
        IPlayer player = new PlayerDummy();

        target.add(set, player);
        assertNull(event);
    }

    @Test
    public void add_fail_noGame() {
        target.add(null, null);
    }

    @Test
    public void add_fail_notValidSet() {
        ICard card1 = new CardStub("color", "form", "fill", 0);
        ICard card2 = new CardStub("color", "form", "fill", 1);
        ISet set = new SetStub(card1, card1, card2);

        target.registerPlayer("test");
        IPlayer player = target.getPlayers().get(0);
        target.add(set, player);

        assertNull(event);
        assertEquals(0, player.getScore());
    }

    @Test
    public void add_success_withPlayer() {
        ICard card = new CardStub("color", "form", "fill", 0);
        ISet set = new SetStub(card, card, card);

        target.registerPlayer("test");
        IPlayer player = target.getPlayers().get(0);
        target.add(set, player);

        assertNotNull(event);
        assertEquals(1, player.getScore());
    }

    @Test
    public void add_success_withoutPlayer() {
        ICard card = new CardStub("color", "form", "fill", 0);
        ISet set = new SetStub(card, card, card);

        target.registerPlayer("test");
        target.add(set, null);
        assertNotNull(event);
    }

    @Test
    public void getSet_fail() {
        assertNull(target.getSet());
    }

    @Test
    public void registerPlayer_newPlayer() {
        target.registerPlayer("test");
        IGame game = target.getGame();
        assertNotNull(game);
        assertNull(game.getWinner());
        assertNotNull(game.getPlayers());
        assertFalse(game.getPlayers().isEmpty());
        assertNotNull(game.getFieldCardList());
        assertNotNull(game.getFieldCardList().getGame());
        assertFalse(game.getFieldCardList().getCards().isEmpty());
        assertNotNull(game.getUnusedCardList());
        assertNotNull(game.getUnusedCardList().getGame());
        assertFalse(game.getUnusedCardList().getCards().isEmpty());
    }


    @Test
    public void registerPlayer_successCpu() {
        target.registerPlayer("player1");
        target.setCpu(CpuLevel.EASY.toString());
        target.registerPlayer("player2");
    }

    @Test
    public void setCpu_success() {
        target.registerPlayer("player");
        target.setCpu(CpuLevel.EASY.toString());
        assertEquals(CpuLevel.EASY.toString(), target.getActiveCpu());
    }

    @Test
    public void setCpu_successSwitch() {
        target.registerPlayer("player");
        target.setCpu(CpuLevel.EASY.toString());
        target.setCpu(CpuLevel.EASY.toString());
        assertEquals(CpuLevel.EASY.toString(), target.getActiveCpu());
    }

    @Test
    public void getCpus_success() {
        assertFalse(target.getCpus().isEmpty());
    }

    @Test
    public void getActiveCpu_fail() {
        assertNull(target.getActiveCpu());
    }
}
