package de.htwg.se.setgame.controller.cpu;

/**
 * @author Philipp Daniels
 */
public class CpuNormal extends AbstractCpu {

    public CpuNormal() {
        super(100 * 1000);
    }

    @Override
    public CpuLevel getLevel() {
        return CpuLevel.NORMAL;
    }
}
