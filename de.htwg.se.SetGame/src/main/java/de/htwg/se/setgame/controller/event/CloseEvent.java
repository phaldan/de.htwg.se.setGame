package de.htwg.se.setgame.controller.event;

import de.htwg.se.setgame.util.observer.Event;
import org.apache.log4j.Logger;

/**
 * @author Philipp Daniels
 */
public class CloseEvent implements Event {

    private static final Logger LOGGER = Logger.getLogger(CloseEvent.class);

    public CloseEvent() {
        LOGGER.debug("Create CloseEvent");
    }
}
