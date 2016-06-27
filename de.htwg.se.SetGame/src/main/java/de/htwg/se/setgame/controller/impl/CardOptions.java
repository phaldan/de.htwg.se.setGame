package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.IOption;
import de.htwg.se.setgame.model.IOptionValue;
import de.htwg.se.setgame.util.persistence.DaoManager;
import de.htwg.se.setgame.util.persistence.OptionDao;
import de.htwg.se.setgame.util.persistence.OptionValueDao;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Philipp Daniels
 */
public class CardOptions {

    private final OptionDao optionDao;
    private final OptionValueDao optionValueDao;

    /**
     * @param dao Instance of DaoManager
     */
    protected CardOptions(DaoManager dao) {
        this.optionDao = dao.getOption();
        this.optionValueDao = dao.getOptionValue();
    }

    /**
     * @return Return list of IOptionValue instances
     */
    protected List<IOption> getValues() {
        List<IOption> list = new LinkedList<>();
        createForm(list);
        createFill(list);
        createColor(list);
        createCount(list);
        return list;
    }

    private IOption createOption(String name, List<IOption> list) {
        IOption option = optionDao.create();
        option.setName(name);
        optionDao.add(option);
        list.add(option);
        return option;
    }

    private IOptionValue createValue(IOption option, String value) {
        IOptionValue entity = optionValueDao.create();
        entity.setOption(option);
        entity.setValue(value);
        optionValueDao.add(entity);
        return entity;
    }

    private void createForm(List<IOption> list) {
        IOption option = createOption("Form", list);
        LinkedHashSet<IOptionValue> values = new LinkedHashSet<>();
        values.add(createValue(option, "ovally"));
        values.add(createValue(option, "wave"));
        values.add(createValue(option, "balk"));
        option.setOptionValues(values);
    }

    private void createColor(List<IOption> list) {
        IOption option = createOption("Color", list);
        LinkedHashSet<IOptionValue> values = new LinkedHashSet<>();
        values.add(createValue(option, "red"));
        values.add(createValue(option, "blue"));
        values.add(createValue(option, "green"));
        option.setOptionValues(values);
    }

    private void createFill(List<IOption> list) {
        IOption option = createOption("Fill", list);
        LinkedHashSet<IOptionValue> values = new LinkedHashSet<>();
        values.add(createValue(option, "halffill"));
        values.add(createValue(option, "fill"));
        values.add(createValue(option, "empty"));
        option.setOptionValues(values);
    }

    private void createCount(List<IOption> list) {
        IOption option = createOption("Count", list);
        LinkedHashSet<IOptionValue> values = new LinkedHashSet<>();
        values.add(createValue(option, "one"));
        values.add(createValue(option, "two"));
        values.add(createValue(option, "three"));
        option.setOptionValues(values);
    }
}
