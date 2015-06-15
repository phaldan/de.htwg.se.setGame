package de.htwg.se.setgame.aview;

import de.htwg.se.setgame.aview.gui.GameField;
import de.htwg.se.setgame.aview.gui.GraphicalUI;
import de.htwg.se.setgame.aview.gui.SetButton;
import de.htwg.se.setgame.aview.tui.TextUI;
import de.htwg.se.setgame.aview.tui.action.ActionListImpl;
import de.htwg.se.setgame.controller.IController;
import org.apache.log4j.Logger;

import javax.swing.*;

/**
 * @author Philipp Daniels
 */
public class ViewFactory {

    private static final Logger LOGGER = Logger.getLogger(ViewFactory.class.getName());
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
        LOGGER.info("Initiate GUI");
        GameField field = new GameField(controller);
        SetButton button = new SetButton(controller, new JOptionPane(), field);
        return new GraphicalUI(controller, field, button);
    }

    /**
     * @return Return TextUI instance
     */
    public TextUI createTUI() {
        LOGGER.info("Initiate TUI");
        TextUI tui = new TextUI(controller, new ActionListImpl(controller));
        tui.printTUI();
        return tui;
    }
}
