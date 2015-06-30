package de.htwg.se.setgame.controller.cpu;

/**
 * @author Philipp Daniels
 */
public class CpuEasy extends AbstractCpu {

    public static final int SECONDS = 300;

    public CpuEasy() {
        super(SECONDS * MS);
    }

    @Override
    public CpuLevel getLevel() {
        return CpuLevel.EASY;
    }
}
