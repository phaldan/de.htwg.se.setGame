package de.htwg.se.setgame.aview.tui;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.model.ICard;

import java.util.Map;

/**
 * @author Philipp Daniels
 */
public class SolutionAction extends Action {

    public static final String CMD = "s";
    public static final String DESC = "If you want to know the solution";
    public static final String OUTPUT = "SOLUTION:\n";
    public static final String FORMAT = "%d: %s%n";

    /**
     * @param controller Instance of IController
     */
    public SolutionAction(IController controller) {
        super(controller);
    }

    @Override
    public String getCommand() {
        return CMD;
    }

    @Override
    public String getDescription() {
        return DESC;
    }

    @Override
    public String execute(String[] input) {
        StringBuilder builder = new StringBuilder(OUTPUT);
        return process(builder).toString();
    }

    private StringBuilder process(StringBuilder builder) {
        for (ICard card: getController().getSetInField()) {
            iterateCards(builder, card);
        }
        return builder;
    }

    private void iterateCards(StringBuilder builder, ICard card) {
        for (Map.Entry<Integer, ICard> entry: getController().getCardsAndTheIndexOfCardInField().entrySet()) {
            if (entry.getValue().equals(card)) {
                builder.append(String.format(FORMAT, entry.getKey(), card));
            }
        }
    }
}
