package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.IOption;

/**
 * @author Philipp Daniels
 */
public class Option implements IOption {

    private Integer id;
    private String name;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
