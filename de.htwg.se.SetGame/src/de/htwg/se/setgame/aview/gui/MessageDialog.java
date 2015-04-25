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

    public void show(String title, String message) {
        pane.setMessage(message);
        JDialog dialog = pane.createDialog(title);
        dialog.setVisible(true);
    }

}
