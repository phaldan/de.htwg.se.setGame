package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.IController;

import javax.swing.*;

/**
 * @author Philipp Daniels
 */
public class HelpMenuItem extends MenuItem {

    public static final String TEXT = "Help";
    public static final String TITLE = "Help";
    private static final String LS = "\n";
    private StringBuilder builder;

    /**
     * @param controller Instance of IController
     * @param pane       Instance of JOptionPane
     */
    public HelpMenuItem(IController controller, JOptionPane pane) {
        super(controller, TEXT, pane);
        builder = new StringBuilder();
    }

    @Override
    public void execute() {
        createMessage();
        handlePane(builder.toString());
        handleDialog(TITLE);
    }

    private void createMessage(){
        addPassage1();
        addPassage2();
        addPassage3();
        addPassage4();
        addPassage5();
        addPassage6();
        addPassage7();
        add("Have fun!");
    }

    private void addPassage1() {
        add("The SET game is a puzzle that uses cards");
        add("which have 4 features on them:");
        add("COLORS, SYMBOLS, SHADINGS");
        add("and the NUMBER of symbols.");
        add(LS);
    }

    private void addPassage2() {
        add("The COLOR can be");
        add("RED, GREEN or PURPLE...");
        add(LS);
    }

    private void addPassage3() {
        add("... the SYMBOLS can be");
        add("SQUIGGLES, DIAMONDS or OVALS...");
        add(LS);
    }

    private void addPassage4() {
        add("...the SHADING can be");
        add("SOLID, STRIPED or QUOLINED...");
        add(LS);
    }

    private void addPassage5() {
        add("...and for NUMBER, each card has either");
        add("ONE, TWO or THREE symbols on it.");
        add(LS);
    }

    private void addPassage6() {
        add("There is only one rule to make a SET.");
        add(LS);
    }

    private void addPassage7() {
        add("A SET is 3 cards in which each individual feature is");
        add("either all the SAME on each card...");
        add("...or all DIFFERENT on each card.");
        add(LS);
    }

    private void add(String text) {
        builder.append(text).append(LS);
    }

    private void handlePane(String message) {
        getPane().setMessage(message);
        getPane().setMessageType(JOptionPane.INFORMATION_MESSAGE);
        getPane().setOptionType(JOptionPane.DEFAULT_OPTION);
    }

    private void handleDialog(String title) {
        JDialog dialog = getPane().createDialog(this, title);
        dialog.setVisible(true);
    }
}
