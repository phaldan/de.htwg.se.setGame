package de.htwg.se.setgame;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.htwg.se.setgame.aview.tui.TextUI;
import de.htwg.se.setgame.controller.IController;

import de.htwg.se.setgame.aview.ViewFactory;

/**
 * @author Philipp
 */
public final class SetGame {
	private static TextUI tui;
	private IController controller;
	private static SetGame instance = null;

	/**
	 * @return Instance of SetGame
	 */
	public static SetGame getInstance() {
		return getInstance(true);
	}

	/**
	 * Reset instance
	 */
	protected static void clearInstance() {
		instance = null;
	}

	/**
	 * @param activateGui Flag to disable GraphicalUI
	 * @return Instance of SetGame
	 */
	public static SetGame getInstance(boolean activateGui) {
		return (instance == null) ? createInstance(activateGui): instance;
	}

	private static SetGame createInstance(boolean activateGui) {
		instance = new SetGame(activateGui);
		return instance;
	}

    private SetGame(boolean activateGui) {
		PropertyConfigurator.configure("log4j.properties");
        initDependencyInjector();
        initUserInterface(activateGui);
    }

    private void initDependencyInjector() {
        Injector injector = Guice.createInjector(new SetGameModule());
        controller = injector.getInstance(IController.class);
    }

    private void initUserInterface(boolean activateGui) {
		ViewFactory factory = new ViewFactory(controller);

        if (activateGui) {
			factory.createGUI().setVisible(true);
		}

		tui = factory.createTUI();
    }

	/**
	 * @return Return instance IController
	 */
	public IController getIController(){
		return controller;
	}

	/**
	 * @param args Command line parameter
	 */
	public static void main(String[] args) {
		SetGame.getInstance();
		handleTuiProcessing();
	}

	private static void handleTuiProcessing() {
		boolean cont = true;
		Scanner scanner = new Scanner(System.in);

		while (cont) {
			cont = tui.processInputLine(scanner.nextLine());
		}
	}
		
	
}
