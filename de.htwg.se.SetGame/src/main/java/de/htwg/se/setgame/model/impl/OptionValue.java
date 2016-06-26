package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.IOption;
import de.htwg.se.setgame.model.IOptionValue;

/**
 * @author Philipp Daniels
 */
public class OptionValue implements IOptionValue {

    private Integer id;
    private IOption option;
    private String value;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public IOption getOption() {
        return option;
    }

    @Override
    public void setOption(IOption option) {
        this.option = option;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
