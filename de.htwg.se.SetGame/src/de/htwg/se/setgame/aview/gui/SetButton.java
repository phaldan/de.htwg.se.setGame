package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.observer.Event;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


/**
 * @author raina
 */
public class SetButton extends Panel {
    private static final long serialVersionUID = 1L;
    private IController controller;

    public static final String DEFAULT_TEXT_FIELD = "0";
    public static final String DIALOG_TITLE = "Choice";
    public static final String DIALOG_MESSAGE = "Which Player?";
    public static final String PLAYER1 = "Player 1";
    public static final String PLAYER2 = "Player 2";
    public static final int GRID_COLS = 4;
    public static final int GRID_ROWS = 1;
    private JTextField player1;
    private JTextField player2;
    private JOptionPane pane;
    private JDialog dialog;
    private GameField field;

    /**
     * @param controller Instance of IController
     */
    public SetButton(IController controller, JOptionPane pane, GameField field) {
        this.controller = controller;
        controller.addObserver(this);
        initPanel();
        initPane(pane);
        this.field = field;
    }

    private void initPanel() {
        setLayout(new GridLayout(2, 1));
        add(createButton());
        add(createTextFields());
    }

    private JPanel createButton() {
        JButton button = new JButton("SET");
        button.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(button);
        return panel;
    }

    private void initPane(JOptionPane pane) {
        this.pane = pane;
        pane.setMessage(DIALOG_MESSAGE);
        pane.setMessageType(JOptionPane.QUESTION_MESSAGE);
        pane.setOptionType(JOptionPane.DEFAULT_OPTION);
        pane.setOptions(new Object[]{PLAYER1, PLAYER2});
        dialog = pane.createDialog(this, DIALOG_TITLE);
    }

    private JPanel createTextFields() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(GRID_ROWS, GRID_COLS));

        player1 = createPlayer(PLAYER1, panel);
        player2 = createPlayer(PLAYER2, panel);

        return panel;
    }

    private JTextField createPlayer(String text, JPanel panel) {
        panel.add(new JLabel(text));

        JTextField field = new JTextField(DEFAULT_TEXT_FIELD);
        field.setEditable(false);
        panel.add(field);

        return field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        choice();
        updateSB();
    }

    private void choice() {
        dialog.setVisible(true);
        Object selected = pane.getValue();
        int player = selected.equals(PLAYER1) ? 1 : 2;
        LinkedList<ICard> list = new LinkedList<>(field.getSelected());
        controller.isASetForController(list.poll(), list.poll(), list.poll(), player);
    }

    private void updateSB() {
        player1.setText(Integer.toString(controller.getPlayerOnePoints()));
        player2.setText(Integer.toString(controller.getPlayerTwoPoints()));
    }

    @Override
    public void update(Event e) {
        updateSB();
    }

    /**
     * @return Return Player1 TextField
     */
    protected JTextField getPlayer1() {
        return player1;
    }

    /**
     * @return Return Player2 TextField
     */
    protected JTextField getPlayer2() {
        return player2;
    }
}
