package de.htwg.se.setgame.controller;

import de.htwg.se.setgame.controller.cpu.CpuLevel;

/**
 * @author Philipp Daniels
 */
public interface CpuPlayer {

    /**
     * Activate CpuPlayer for new IController instance
     */
    void activate(IController controller);

    /**
     * Disable CpuPlayer for Icontroller instance
     */
    void disable(IController controller);

    /**
     * @return Return skill level of CpuPlayer
     */
    CpuLevel getLevel();
}
