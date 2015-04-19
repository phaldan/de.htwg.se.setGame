package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.util.observer.*;
import de.htwg.se.setgame.util.observer.Event;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * @author raina
 */
public class SetButton extends JPanel implements ActionListener, IObserver {
    private static final long serialVersionUID = 1L;
    private JButton setButton;
    private IController controller;

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static JTextField player1;
    private static JTextField player2;

    /**
     * @param controller Instance of IController
     */
    public SetButton(IController controller) {
        this.controller = controller;
        controller.addObserver(this);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));

        JLabel p1 = new JLabel(" Player 1 ");
        JLabel p2 = new JLabel(" Player 2 ");
        player1 = new JTextField("0", FIVE);
        player2 = new JTextField("0", FIVE);
        player1.setEditable(false);
        player2.setEditable(false);

        setButton = new JButton("SET");
        setButton.addActionListener(this);
        panel1.add(setButton);

        panel2.setLayout(new GridLayout(ONE, FOUR));
        panel2.add(p1);
        panel2.add(player1);
        panel2.add(p2);
        panel2.add(player2);

        mainPanel.add(panel1);
        mainPanel.add(panel2);
        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(setButton)) {
            choice();
        }
        updateSB();
    }

    private void choice() {
        Object[] options = {"Player1", "Player2"};

        int selected = JOptionPane.showOptionDialog(null,
                "Which Player?", "Choice", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (selected == ZERO) {
            controller.isASetForController(GameField.getCardforSetOne(), GameField.getCardforSetTwo(), GameField.getCardforSetThree(), ONE);

        } else if (selected == ONE) {
            controller.isASetForController(GameField.getCardforSetOne(), GameField.getCardforSetTwo(), GameField.getCardforSetThree(), TWO);
        }
    }

    private void updateSB() {
        player1.setText(Integer.toString(controller.getPlayerOnePoints()));
        player2.setText(Integer.toString(controller.getPlayerTwoPoints()));
    }

    @Override
    public void update(Event e) {
        updateSB();
    }
}
