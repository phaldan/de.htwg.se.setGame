package de.htwg.se.setgame.aview.gui;

import java.util.List;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.LinkedList;
import java.util.Map;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.observer.Event;

/**
 * @author raina
 */
public class GameField extends Panel {

    private static final long serialVersionUID = 1L;

    public static final int MAX_SELECTED = 3;
    public static final String DIALOG_MESSAGE = "Only THREE cards addicted a SET :)";
    public static final String DIALOG_TITLE = "Warning";
    private List<Field> fields;

    private IController controller;
    private MessageDialog dialog;
    private CardToImageMapper mapper;
    private Map<Integer, ICard> cards;

    /**
     * @param controller Instance of IController
     */
    public GameField(IController controller) {
        this(controller, new MessageDialog());
    }

    /**
     * @param controller Instance of IController
     * @param dialog Instance of MessageDialog
     */
    protected GameField(IController controller, MessageDialog dialog) {
        this.controller = controller;
        this.dialog = dialog;
        mapper = new CardToImageMapper();
        cards = controller.getCardsAndTheIndexOfCardInField();

        initFields();
    }

    private void initFields() {
        fields = new LinkedList<>();
        for (int i = 0; i < cards.size(); i++) {
            fields.add(new Field(this, new MessageDialog()));
        }
        updateFields();
    }

    private void updateFields() {
        for (Map.Entry<Integer, ICard> entry : cards.entrySet()) {
            Field field = fields.get(entry.getKey());
            setFieldImage(entry.getValue(), field);
        }
    }

    private void setFieldImage(ICard card, Field field) {
        String image = mapper.getImage(card);
        URL url = getClass().getResource(image);
        field.setImage(url);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (getSelected().size() > MAX_SELECTED) {
            dialog.show(DIALOG_TITLE, DIALOG_MESSAGE);
            reset();
        }
    }

    /**
     * @return List of selected cards.
     */
    public List<ICard> getSelected() {
        List<ICard> list = new LinkedList<>();
        for (Map.Entry<Integer, ICard> entry : cards.entrySet()) {
            handleSelected(entry, list);
        }
        return list;
    }

    private void handleSelected(Map.Entry<Integer, ICard> entry, List<ICard> list) {
        Field field = fields.get(entry.getKey());
        if (field.isSelected()) {
            list.add(entry.getValue());
        }
    }

    private void reset() {
        for (Field field: fields) {
            field.reset();
        }
    }

    @Override
    public void update(Event e) {
        cards = controller.getCardsAndTheIndexOfCardInField();
        updateFields();

        reset();
    }

    /**
     * @return List of Field instances
     */
    protected List<Field> getFields() {
        return fields;
    }
}
