package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.IController;

import javax.swing.*;

/**
 * @author Philipp Daniels
 */
public class CloseMenuItem extends MenuItem {

    public static final String TEXT = "Close";
    public static final String TITLE = "Close";
    public static final String MESSAGE = "Really finish the game?";

    /**
     * @param controller Instance of IController
     */
    public CloseMenuItem(IController controller, JOptionPane pane) {
        super(controller, TEXT, pane);
    }

    @Override
    public void execute() {
        if(showConfirmDialog(TITLE, MESSAGE)){
            getController().exit();
        }
    }

    private boolean showConfirmDialog(String title, String message) {
        handlePane(message);
        handleDialog(title);
        return getPane().getValue().equals(JOptionPane.YES_OPTION);
    }

    private void handlePane(String message) {
        getPane().setMessage(message);
        getPane().setMessageType(JOptionPane.QUESTION_MESSAGE);
        getPane().setOptionType(JOptionPane.YES_NO_OPTION);
    }

    private void handleDialog(String title) {
        JDialog dialog = getPane().createDialog(this, title);
        dialog.setVisible(true);
    }
}
