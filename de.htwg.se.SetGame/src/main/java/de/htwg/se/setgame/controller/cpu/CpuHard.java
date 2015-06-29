package de.htwg.se.setgame.controller.cpu;

/**
 * @author Philipp Daniels
 */
public class CpuHard extends AbstractCpu {

    public CpuHard() {
        super(30 * 1000);
    }

    @Override
    public CpuLevel getLevel() {
        return CpuLevel.HARD;
    }
}
