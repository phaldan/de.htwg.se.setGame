package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.model.ICard;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Philipp Daniels
 */
public class CardToImageMapper {

    private static final int COLOR_OFFSET = 27;
    private static final int COUNT_OFFSET = 9;
    private static final int FILL_OFFSET = 3;
    private static final int FORM_OFFSET = 1;
    public static final String NAME = "/pack/%d.gif";

    private Map<String, Integer> color = new HashMap<>();
    private Map<Integer, Integer> count = new HashMap<>();
    private Map<String, Integer> fill = new HashMap<>();
    private Map<String, Integer> form = new HashMap<>();

    public CardToImageMapper() {
        initColor();
        initCount();
        initFill();
        initForm();
    }

    private void initColor() {
        color.put("red", 0);
        color.put("green", 1);
        color.put("purple", 2);
    }

    private void initCount() {
        count.put(1, 0);
        count.put(2, 1);
        count.put(3, 2);
    }

    private void initFill() {
        fill.put("halffill", 0);
        fill.put("fill", 1);
        fill.put("empty", 2);
    }

    private void initForm() {
        form.put("ovally", 0);
        form.put("wave", 1);
        form.put("balk", 2);
    }

    public URL getImage(ICard c) {
        int index = getColor(c) + getCount(c) + getFill(c) + getForm(c);
        String name = String.format(NAME, index);
        return getClass().getResource(name);
    }

    private int getColor(ICard card) {
        return color.get(card.getColor()) * COLOR_OFFSET;
    }

    private int getCount(ICard card) {
        return count.get(card.getNumberOfComponents()) * COUNT_OFFSET;
    }

    private int getFill(ICard card) {
        return fill.get(card.getPanelFilling()) * FILL_OFFSET;
    }

    private int getForm(ICard card) {
        return form.get(card.getForm()) * FORM_OFFSET;
    }
}
