package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.IController;

import javax.swing.*;

/**
 * @author Philipp Daniels
 */
public class NewMenuItem extends MenuItem {

    public static final String TEXT = "New Game";
    public static final String TITLE1 = "Winner";
    public static final String TITLE2 = "Fail";
    public static final String TITLE3 = "Choice";
    public static final String MESSAGE1 = "PlayerOne wins!";
    public static final String MESSAGE2 = "PlayerTwo wins!";
    public static final String MESSAGE3 = "Dead heat!";
    public static final String MESSAGE4 = "Really start a new game?";

    /**
     * @param controller Instance of IController
     * @param pane       Instance of JOptionPane
     */
    public NewMenuItem(IController controller, JOptionPane pane) {
        super(controller, TEXT, pane);
    }

    @Override
    public void execute() {
        if (showConfirm(TITLE3, MESSAGE4)) {
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
        if(getController().getPlayerOnePoints() > getController().getPlayerTwoPoints()) {
            playerOneWin();
        } else if (getController().getPlayerOnePoints() < getController().getPlayerTwoPoints()) {
            playerTwoWin();
        } else {
            noOneWin();
        }
    }

    private void playerOneWin() {
        showMessage(TITLE1, MESSAGE1);
    }

    private void playerTwoWin() {
        showMessage(TITLE1, MESSAGE2);
    }

    private void noOneWin() {
        showMessage(TITLE2, MESSAGE3);
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
