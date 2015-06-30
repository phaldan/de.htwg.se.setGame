package de.htwg.se.setgame.controller.cpu;

/**
 * @author Philipp Daniels
 */
public class CpuNormal extends AbstractCpu {

    public static final int SECONDS = 100;

    public CpuNormal() {
        super(SECONDS * MS);
    }

    @Override
    public CpuLevel getLevel() {
        return CpuLevel.NORMAL;
    }
}
