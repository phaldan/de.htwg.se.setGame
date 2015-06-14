package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.model.IPlayer;

import javax.swing.*;
import java.util.List;

/**
 * @author Philipp Daniels
 */
public class NewMenuItem extends MenuItem {

    public static final String TEXT = "New Game";
    public static final String TITLE_WINNER = "Winner";
    public static final String TITLE_DRAW = "Fail";
    public static final String TITLE_RESTART = "Choice";
    public static final String MSG_WINNER = "%s wins!";
    public static final String MSG_DRAW = "Dead heat!";
    public static final String MSG_RESTART = "Really start a new game?";

    /**
     * @param controller Instance of IController
     * @param pane       Instance of JOptionPane
     */
    public NewMenuItem(IController controller, JOptionPane pane) {
        super(controller, TEXT, pane);
    }

    @Override
    public void execute() {
        if (showConfirm(TITLE_RESTART, MSG_RESTART)) {
            handleMessage();
            getController().newGame();
        }
    }

    private boolean showConfirm(String title, String message) {
        handlePane(message, JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
        handleDialog(title);
        return getPane().getValue().equals(JOptionPane.YES_OPTION);
    }

    private void handleMessage() {
        IPlayer player = getWinner();
        if(player != null) {
            showMessage(TITLE_WINNER, String.format(MSG_WINNER, player));
        } else {
            showMessage(TITLE_DRAW, MSG_DRAW);
        }
    }

    private IPlayer getWinner() {
        List<IPlayer> players = getController().getPlayers();
        int max = -1;
        IPlayer winner = null;
        for (IPlayer player: players) {
            if (player.getScore() > max) {
                max = player.getScore();
                winner = player;
            } else if (player.getScore() == max) {
                winner = null;
            }
        }
        return winner;
    }

    private void showMessage(String title, String message) {
        handlePane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
        handleDialog(title);
    }

    private void handlePane(String message, int messageType, int optionType) {
        getPane().setMessage(message);
        getPane().setMessageType(messageType);
        getPane().setOptionType(optionType);
    }

    private void handleDialog(String title) {
        JDialog dialog = getPane().createDialog(this, title);
        dialog.setVisible(true);
    }
}
