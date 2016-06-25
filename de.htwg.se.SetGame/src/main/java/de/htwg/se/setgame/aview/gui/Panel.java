package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.util.observer.IObserver;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author Philipp Daniels
 */
public abstract class Panel extends JPanel implements ActionListener, IObserver {

    private final IController controller;

    protected Panel(IController controller) {
        this.controller = controller;
    }

    protected IController getController() {
        return controller;
    }
}
