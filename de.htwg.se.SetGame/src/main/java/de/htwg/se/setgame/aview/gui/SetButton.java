package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.controller.event.CloseEvent;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.model.ISet;
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

    public static final String DIALOG_TITLE = "Choice";
    public static final String DIALOG_MESSAGE = "Which Player?";
    public static final int GRID_COLS = 4;
    public static final int GRID_ROWS = 1;
    private JOptionPane pane;
    private GameField field;
    private Map<JTextField, IPlayer> players = new HashMap<>();

    /**
     * @param controller Instance of IController
     */
    public SetButton(IController controller, JOptionPane pane, GameField field) {
        this.controller = controller;
        controller.addObserver(this);
        this.field = field;
        this.pane = pane;
        initPanel();
    }

    private void initPanel() {
        setLayout(new GridLayout(2, 1));
        players = new HashMap<>();
        removeAll();
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

    private JPanel createTextFields() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
        createPlayers(panel);
        return panel;
    }

    private void createPlayers(JPanel panel) {
        for (IPlayer player: controller.getPlayers()) {
            JTextField textField = createPlayer(player, panel);
            players.put(textField, player);
        }
    }

    private JTextField createPlayer(IPlayer player, JPanel panel) {
        panel.add(new JLabel(player.getName()));

        JTextField textField = new JTextField("" + player.getScore());
        textField.setEditable(false);
        panel.add(textField);
        return textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        choice();
        initPanel();
    }

    private void choice() {
        Object selected = getDialogValue();
        if (selected != null) {
            LinkedList<ICard> list = new LinkedList<>(field.getSelected());
            ISet set = controller.createSet();
            set.setFirst(list.poll());
            set.setSecond(list.poll());
            set.setThird(list.poll());
            controller.add(set, (IPlayer) selected);
        }
    }

    private Object getDialogValue() {
        pane.setMessage(DIALOG_MESSAGE);
        pane.setMessageType(JOptionPane.QUESTION_MESSAGE);
        pane.setOptionType(JOptionPane.DEFAULT_OPTION);
        pane.setOptions(players.values().toArray());
        createDialog();
        return pane.getValue();
    }

    private void createDialog() {
        JDialog dialog = pane.createDialog(this, DIALOG_TITLE);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    private void updateSB() {
        for (Map.Entry<JTextField, IPlayer> map: players.entrySet()) {
            map.getKey().setText(Integer.toString(map.getValue().getScore()));
        }
    }

    @Override
    public void update(Event e) {
        if (e == null || !e.getClass().equals(CloseEvent.class)) {
            initPanel();
        }
    }
}
