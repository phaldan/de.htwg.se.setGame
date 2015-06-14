package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.IController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Philipp Daniels
 */
public abstract class MenuItem extends JMenuItem implements ActionListener {

    private IController controller;
    private JOptionPane pane;

    /**
     * @param controller Instance of IController
     * @param text Text for JMenuItem
     * @param pane Instance of JOptionPane
     */
    public MenuItem(IController controller, String text, JOptionPane pane) {
        super(text);
        this.controller = controller;
        this.pane = pane;
    }

    /**
     * @return Return IController instance
     */
    public IController getController() {
        return controller;
    }

    /**
     * @return Return JOptionPane instance
     */
    public JOptionPane getPane() {
        return pane;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(this)) {
            execute();
        }
    }

    /**
     * Execute Action
     */
    public abstract void execute();

}