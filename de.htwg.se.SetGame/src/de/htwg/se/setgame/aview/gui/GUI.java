package de.htwg.se.setgame.aview.gui;

import java.awt.GridLayout;

import javax.swing.*;

import de.htwg.se.setgame.controller.IController;

/**
 * @author Philipp Daniels
 */
public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String TITLE = "SET - The ultimate challenge!";

	/**
	 * @param controller Instance of IController
	 */
	public GUI(IController controller) {
		setJMenuBar(new MenuBar(controller));
		setContentPane(createMainPanel(controller));
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private JPanel createMainPanel(IController controller) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.add(new GameField(controller));
		mainPanel.add(createMiniPanel(controller));
		return mainPanel;
	}

	private JPanel createMiniPanel(IController controller) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(new SetButton(controller));
		return panel;
	}
}
