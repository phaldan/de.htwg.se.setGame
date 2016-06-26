package de.htwg.se.setgame.model.impl;

import de.htwg.se.setgame.model.IOption;
import de.htwg.se.setgame.model.IOptionValue;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Philipp Daniels
 */
public class Option implements IOption {

    private Integer id;
    private String name;
    private Set<IOptionValue> optionValues = new LinkedHashSet<>();

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

    @Override
    public Set<IOptionValue> getOptionValues() {
        return optionValues;
    }

    @Override
    public void setOptionValues(Set<IOptionValue> set) {
        this.optionValues = set;
    }
}
