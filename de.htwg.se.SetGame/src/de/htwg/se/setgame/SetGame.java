package de.htwg.se.setgame;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import de.htwg.se.setgame.aview.gui.GameField;
import de.htwg.se.setgame.aview.gui.SetButton;
import de.htwg.se.setgame.aview.tui.action.ActionListImpl;
import org.apache.log4j.PropertyConfigurator;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.htwg.se.setgame.aview.gui.GUI;
import de.htwg.se.setgame.aview.tui.TextUI;
import de.htwg.se.setgame.controller.IController;

/**
 * @author Philipp
 */
public final class SetGame {
	private static Scanner scanner;
	private static TextUI tui;
	private IController controller;
	private static SetGame instance = null;

	/**
	 * @return Instance of SetGame
	 * @throws IOException
	 */
	public static SetGame getInstance() throws IOException {
		return getInstance(true);
	}

	/**
	 * @param activateGui Flag to disable GUI
	 * @return Instance of SetGame
	 * @throws IOException
	 */
	public static SetGame getInstance(boolean activateGui) throws IOException {
		return (instance == null) ? createInstance(activateGui): instance;
	}

	private static SetGame createInstance(boolean activateGui) throws IOException {
		instance = new SetGame(activateGui);
		return instance;
	}

    private SetGame(boolean activateGui) throws IOException {
        initLogger();
        initDependencyInjector();
        initUserInterface(activateGui);
    }

    private void initLogger() throws IOException {
		Properties props = new Properties();
		props.load(getClass().getResourceAsStream("/log4j.properties"));
		PropertyConfigurator.configure(props);
    }

    private void initDependencyInjector() {
        Injector injector = Guice.createInjector(new SetGameModule());
        controller = injector.getInstance(IController.class);
    }

    private void initUserInterface(boolean activateGui) {
        if (activateGui) {
			GUI gui = new GUI(controller, new GameField(controller), new SetButton(controller));
			gui.setVisible(true);
		}

        tui = new TextUI(controller, new ActionListImpl(controller));
		tui.printTUI();
    }

	/**
	 * @return Return instance IController
	 */
	public IController getIController(){
		return controller;
	}

	/**
	 * @param args Command line parameter
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		SetGame.getInstance();
		boolean cont = true;
		scanner = new Scanner(System.in);
		while(cont){ 
			cont = tui.processInputLine(scanner.nextLine());
		}
	}
		
	
}
