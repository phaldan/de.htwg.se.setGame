package de.htwg.se.setgame.controller.cpu;

/**
 * @author Philipp Daniels
 */
public class CpuEasy extends AbstractCpu {

    public CpuEasy() {
        super(300 * 1000);
    }

    @Override
    public CpuLevel getLevel() {
        return CpuLevel.EASY;
    }
}
