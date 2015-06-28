package de.htwg.se.setgame.aview.gui;

import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * @author Philipp Daniels
 */
public class Field extends JButton implements ActionListener {

    private static final Logger LOGGER = Logger.getLogger(Field.class);
    public static final String DIALOG_MESSAGE = "Not a second time :P";
    public static final String DIALOG_TITLE = "Warning";
    private static final int BORDER_WIDTH = 3;

    private boolean selected;
    private MessageDialog dialog;

    /**
     * @param gameField Instance of GameField
     */
    public Field(GameField gameField, MessageDialog dialog) {
        addActionListener(gameField);
        addActionListener(this);
        gameField.add(this);

        setInitialState();
        this.dialog = dialog;
    }

    private void setInitialState() {
        selected = false;
        setBorder(new LineBorder(Color.GRAY, BORDER_WIDTH));
    }

    /**
     * @param filename String of URL
     */
    public void setImage(String filename) {
        URL url = getClass().getClassLoader().getResource(filename);
        if (url == null) {
            LOGGER.error("File not exist: " + filename);
        } else {
            setIcon(new ImageIcon(url));
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        selected = isSelected() ? showMessage() : highlight();
    }

    private boolean highlight() {
        setBorder(new LineBorder(Color.BLACK, BORDER_WIDTH));
        return true;
    }

    private boolean showMessage() {
        dialog.show(DIALOG_TITLE, DIALOG_MESSAGE);
        return true;
    }

    /**
     * @return Returns true, when user has selected this field.
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * Remove selection
     */
    public void reset() {
        setInitialState();
    }
}
