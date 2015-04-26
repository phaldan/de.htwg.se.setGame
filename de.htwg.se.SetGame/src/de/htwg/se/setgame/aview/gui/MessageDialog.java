package de.htwg.se.setgame.aview.gui;

import javax.swing.*;

/**
 * @author Philipp Daniels
 */
public class MessageDialog {

    private JOptionPane pane;

    /**
     * @param pane Instance of JOptionPane
     */
    protected MessageDialog(JOptionPane pane) {
        this.pane = pane;
        pane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        pane.setOptionType(JOptionPane.DEFAULT_OPTION);
    }

    /**
     * Default constructor
     */
    public MessageDialog() {
        this(new JOptionPane());
    }

    /**
     * @param title Dialog title
     * @param message Dialog message
     */
    public void show(String title, String message) {
        pane.setMessage(message);
        JDialog dialog = pane.createDialog(title);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

}
