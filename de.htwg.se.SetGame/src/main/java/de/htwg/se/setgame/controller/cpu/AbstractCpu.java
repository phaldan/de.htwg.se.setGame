package de.htwg.se.setgame.controller.cpu;

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
    private List<IController> list = new LinkedList<>();
    private long waitTime;
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
            updateTimer();
        }
    }

    @Override
    public void disable(IController controller) {
        if (list.contains(controller)) {
            list.remove(controller);
            updateTimer();
        }
    }

    private void updateTimer() {
        if (timer == null && !list.isEmpty()) {
            timer = new Timer();
            timer.scheduleAtFixedRate(this, waitTime, waitTime);
        } else if (timer != null && list.isEmpty()) {
            timer.cancel();
            timer = null;
        }
    }

    @Override
    public void run() {
        for (IController controller: list) {
            controller.add(controller.getSet(), null);
        }
    }
}
