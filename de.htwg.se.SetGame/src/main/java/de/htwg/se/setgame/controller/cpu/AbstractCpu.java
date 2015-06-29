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
            System.out.println("add timer");
        } else if (timer != null && list.isEmpty()) {
            timer.cancel();
            timer = null;
            System.out.println("clear timer");
        }
    }

    @Override
    public void run() {
        System.out.println("call timer");
        for (IController controller: list) {
            controller.add(controller.getSet(), null);
        }
    }

    /**
     * @return Return skill level of CpuPlayer
     */
    public abstract CpuLevel getLevel();
}
