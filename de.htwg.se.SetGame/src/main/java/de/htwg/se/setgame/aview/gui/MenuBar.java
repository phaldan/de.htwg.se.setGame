package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.controller.IController;

import javax.swing.*;

/**
 * @author raina
 */
public class MenuBar extends JMenuBar {
	
	private static final long serialVersionUID = 1L;
	private static final String TEXT = "Game";
	private IController controller;
	private JMenu menu;

	/**
	 * @param controller Instance of IController
	 */
	public MenuBar(IController controller) {
		this(controller, new JMenu(TEXT));
	}

	/**
	 * @param controller Instance of IController
	 * @param menu Instance of IController
	 */
	public MenuBar(IController controller, JMenu menu) {
		this.controller = controller;
		this.menu = menu;
		add(menu);
		registerMenuItems();
	}

	private void registerMenuItems() {
		addMenuItem(new HelpMenuItem(controller, new JOptionPane()));
		addMenuItem(new CloseMenuItem(controller, new JOptionPane()));
		addMenuItem(new NewMenuItem(controller, new JOptionPane()));
	}

	private void addMenuItem(MenuItem item) {
		item.addActionListener(item);
		menu.add(item);
	}
}
