package de.htwg.se.setgame.aview.gui;

import java.awt.GridLayout;

import javax.swing.*;

import de.htwg.se.setgame.controller.IController;

/**
 * @author Philipp Daniels
 */
public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final String TITLE = "SET - The ultimate challenge!";

	/**
	 * @param controller Instance of IController
	 * @param field Instance of GameField
	 * @param button Instance of SetButton
	 */
	public GUI(IController controller, Panel field, Panel button) {
		setJMenuBar(new MenuBar(controller));
		setContentPane(createMainPanel(field, button));
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	private JPanel createMainPanel(Panel field, Panel button) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.add(field);
		mainPanel.add(createMiniPanel(button));
		return mainPanel;
	}

	private JPanel createMiniPanel(Panel button) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(button);
		return panel;
	}
}
