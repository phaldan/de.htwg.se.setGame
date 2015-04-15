package de.htwg.se.setgame.aview.tui;

import de.htwg.se.setgame.controller.IController;

/**
 * @author Philipp Daniels
 */
public class PointsAction extends Action {

    public static final String CMD = "p";
    public static final String DESC = "If you want to know the game point";
    public static final String OUTPUT = "Player one = %s%nPlayer Two = %s%n";

    public PointsAction(IController controller) {
        super(controller);
    }

    @Override
    public String getCommand() {
        return PointsAction.CMD;
    }

    @Override
    public String getDescription() {
        return PointsAction.DESC;
    }

    @Override
    public String execute(String[] input) {
        return String.format(PointsAction.OUTPUT, getController().getPlayerOnePoints(), getController().getPlayerTwoPoints());
    }
}
