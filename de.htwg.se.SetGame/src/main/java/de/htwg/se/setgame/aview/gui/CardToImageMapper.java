package de.htwg.se.setgame.aview.gui;

import de.htwg.se.setgame.model.ICard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Philipp Daniels
 */
public class CardToImageMapper {

    protected static final String COLOR_1 = "red";
    protected static final String COLOR_2 = "green";
    protected static final String COLOR_3 = "purple";
    protected static final String FORM_1 = "ovally";
    protected static final String FORM_2 = "wave";
    protected static final String FORM_3 = "balk";
    protected static final String FILL_1 = "halffill";
    protected static final String FILL_2 = "fill";
    protected static final String FILL_3 = "empty";
    protected static final int COUNT_1 = 1;
    protected static final int COUNT_2 = 2;
    protected static final int COUNT_3 = 3;
    private static final int COLOR_OFFSET = 27;
    private static final int COUNT_OFFSET = 9;
    private static final int FILL_OFFSET = 3;
    private static final int FORM_OFFSET = 1;
    public static final String NAME = "de.htwg.se.SetGame/src/pack/%d.gif";

    private Map<String, Integer> color = new HashMap<>();
    private Map<Integer, Integer> count = new HashMap<>();
    private Map<String, Integer> fill = new HashMap<>();
    private Map<String, Integer> form = new HashMap<>();

    /**
     * Default constructor
     */
    public CardToImageMapper() {
        initColor();
        initCount();
        initFill();
        initForm();
    }

    private void initColor() {
        color.put(COLOR_1, 0);
        color.put(COLOR_2, 1);
        color.put(COLOR_3, 2);
    }

    private void initCount() {
        count.put(COUNT_1, 0);
        count.put(COUNT_2, 1);
        count.put(COUNT_3, 2);
    }

    private void initFill() {
        fill.put(FILL_1, 0);
        fill.put(FILL_2, 1);
        fill.put(FILL_3, 2);
    }

    private void initForm() {
        form.put(FORM_1, 0);
        form.put(FORM_2, 1);
        form.put(FORM_3, 2);
    }

    /**
     * @param c Instance of ICard
     * @return Returns filename
     */
    public String getImage(ICard c) {
        int index = getColor(c) + getCount(c) + getFill(c) + getForm(c);
        return String.format(NAME, index);
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
