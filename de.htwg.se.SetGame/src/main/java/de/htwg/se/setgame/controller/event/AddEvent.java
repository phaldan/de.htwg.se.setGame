package de.htwg.se.setgame.controller.event;

import de.htwg.se.setgame.util.observer.Event;
import org.apache.log4j.Logger;

/**
 * @author Philipp Daniels
 */
public class AddEvent implements Event {

    private static final Logger LOGGER = Logger.getLogger(AddEvent.class);

    public AddEvent() {
        LOGGER.debug("Create AddEvent");
    }
}
