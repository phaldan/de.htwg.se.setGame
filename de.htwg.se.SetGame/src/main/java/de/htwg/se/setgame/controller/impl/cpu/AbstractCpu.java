package de.htwg.se.setgame.controller.impl.cpu;

import de.htwg.se.setgame.controller.CpuPlayer;
import de.htwg.se.setgame.controller.IController;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Philipp Daniels
 */
public abstract class AbstractCpu extends TimerTask implements CpuPlayer {

    public static final int MS = 1000;
    private final List<IController> list = new LinkedList<>();
    private final long waitTime;
    private Timer timer;

    /**
     * @param waitTime Wait time in milliseconds
     */
    public AbstractCpu(int waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public void activate(IController controller) {
        if (!list.contains(controller)) {
            list.add(controller);
            initiateTimer();
        }
    }

    @Override
    public void disable(IController controller) {
        if (list.contains(controller)) {
            list.remove(controller);
        }
    }

    private void initiateTimer() {
        if (timer == null) {
            timer = new Timer();
            timer.scheduleAtFixedRate(this, waitTime, waitTime);
        }
    }

    @Override
    public void run() {
        for (IController controller: list) {
            controller.add(controller.getSet(), null);
        }
    }

    /**
     * @return Returns list of IController instances.
     */
    public List<IController> getController() {
        return list;
    }
}
