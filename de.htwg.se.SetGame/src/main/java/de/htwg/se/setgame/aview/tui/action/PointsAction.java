package de.htwg.se.setgame.aview.tui.action;

import de.htwg.se.setgame.aview.tui.Action;
import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.model.IPlayer;

/**
 * @author Philipp Daniels
 */
public class PointsAction extends Action {

    public static final String CMD = "p";
    public static final String DESC = "If you want to know the game point";
    public static final String OUTPUT = "%s = %d Points%n";
    public static final String CPU = "CPU = %s%n";

    /**
     * @param controller Instance of IController
     */
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
        StringBuilder builder = new StringBuilder();
        String cpu = getController().getActiveCpu();
        builder.append(String.format(CPU, (cpu == null)? "disabled" : cpu));
        for (IPlayer player: getController().getPlayers()) {
            builder.append(String.format(OUTPUT, player.getName(), player.getScore()));
        }
        return builder.toString();
    }
}
