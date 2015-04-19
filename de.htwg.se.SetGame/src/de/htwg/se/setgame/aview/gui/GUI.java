package de.htwg.se.setgame.aview.gui;

import java.awt.GridLayout;

import javax.swing.*;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.util.observer.Event;
import de.htwg.se.setgame.util.observer.IObserver;

/**
 * @author Philipp Daniels
 */
public class GUI extends JFrame implements IObserver {

	private static final long serialVersionUID = 1L;
	private static final String TITLE = "SET - The ultimate challenge!";

	private GameField gamefield;

	/**
	 * @param controller Instance of IController
	 */
	public GUI(IController controller) {
		controller.addObserver(this);

		gamefield = new GameField(controller);

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
		mainPanel.add(gamefield);
		mainPanel.add(createMiniPanel(controller));
		return mainPanel;
	}

	private JPanel createMiniPanel(IController controller) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(new SetButton(controller));
		return panel;
	}

	@Override
	public void update(Event e) {
		gamefield.updateLink();
	}
}
