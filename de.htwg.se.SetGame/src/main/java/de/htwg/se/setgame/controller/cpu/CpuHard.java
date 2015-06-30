package de.htwg.se.setgame.controller.cpu;

/**
 * @author Philipp Daniels
 */
public class CpuHard extends AbstractCpu {

    public static final int SECONDS = 30;

    public CpuHard() {
        super(SECONDS * MS);
    }

    @Override
    public CpuLevel getLevel() {
        return CpuLevel.HARD;
    }
}
