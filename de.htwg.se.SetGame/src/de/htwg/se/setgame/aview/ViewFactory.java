package de.htwg.se.setgame.aview;

import de.htwg.se.setgame.aview.gui.GameField;
import de.htwg.se.setgame.aview.gui.GraphicalUI;
import de.htwg.se.setgame.aview.gui.SetButton;
import de.htwg.se.setgame.aview.tui.TextUI;
import de.htwg.se.setgame.aview.tui.action.ActionListImpl;
import de.htwg.se.setgame.controller.IController;

import javax.swing.*;

/**
 * @author Philipp Daniels
 */
public class ViewFactory {

    private IController controller;

    /**
     * @param controller Instance of IController
     */
    public ViewFactory(IController controller) {
        this.controller = controller;
    }

    /**
     * @return Return GraphicalUI instance
     */
    public GraphicalUI createGUI() {
        GameField field = new GameField(controller);
        SetButton button = new SetButton(controller, new JOptionPane(), field);
        return new GraphicalUI(controller, field, button);
    }

    /**
     * @return Return TextUI instance
     */
    public TextUI createTUI() {
        TextUI tui = new TextUI(controller, new ActionListImpl(controller));
        tui.printTUI();
        return tui;
    }
}
