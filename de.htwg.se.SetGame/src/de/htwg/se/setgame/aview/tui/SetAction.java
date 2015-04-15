package de.htwg.se.setgame.aview.tui;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.model.ICard;

import java.util.Map;

/**
 * @author Philipp Daniels
 */
public class SetAction extends Action {

    public static final String CMD = "i";
    public static final String DESC = "If you found a set (i PlayerOne/PlayerTwo field1 field2 field3)";
    public static final String INVALID_PARAM = "Not enough parameter.";
    public static final String INVALID_PLAYER = "Unknown player.";
    public static final String INVALID_CARD = "Field has not card";
    public static final String PLAYER1 = "PlayerOne";
    public static final String PLAYER2 = "PlayerTwo";
    public static final String OUTPUT = "Congratulation! It is a SET.";
    public static final int MIN_PARAMETER = 5;
    public static final int PLAYER = 1;
    public static final int FIELD1 = 2;
    public static final int FIELD2 = 3;
    public static final int FIELD3 = 4;

    /**
     * @param controller Instance of IController
     */
    public SetAction(IController controller) {
        super(controller);
    }

    @Override
    public String getCommand() {
        return CMD;
    }

    @Override
    public String getDescription() {
        return DESC;
    }

    @Override
    public String execute(String[] input) {
        return validateInput(input) ? INVALID_PARAM : processPlayer(input[PLAYER], input[FIELD1], input[FIELD2], input[FIELD3]);
    }

    private boolean validateInput(String[] input) {
        return (input == null || input.length < MIN_PARAMETER);
    }

    private String processPlayer(String player, String field1, String field2, String field3) {
        return compareIfPlayerIsRight(player) ? processSet(player, field1, field2, field3) : INVALID_PLAYER;
    }

    private boolean compareIfPlayerIsRight(String string) {
        return string.equals(PLAYER1) || string.equals(PLAYER2);
    }

    private String processSet(String player, String field1, String field2, String field3) {
        Map<Integer, ICard> list = getController().getCardsAndTheIndexOfCardInField();
        ICard card1 = list.get(Integer.parseInt(field1));
        ICard card2 = list.get(Integer.parseInt(field2));
        ICard card3 = list.get(Integer.parseInt(field3));
        return (card1 == null || card2 == null || card3 == null) ? INVALID_CARD: set(player, card1, card2, card3);
    }

    private String set(String playerName, ICard one, ICard two, ICard three) {
        int player = playerName.equals(PLAYER1) ? getController().getPlayerOne() : getController().getPlayerTwo();
        getController().isASetForController(one, two, three, player);
        return OUTPUT;
    }
}
