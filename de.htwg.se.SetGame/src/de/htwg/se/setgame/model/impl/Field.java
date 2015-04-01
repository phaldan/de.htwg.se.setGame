package de.htwg.se.setgame.model.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.model.IField;
import de.htwg.se.setgame.model.IPack;

/**
 * Class Field.
 *
 * @author David Simon & Raina Bertolini
 */
public class Field implements IField {
    public static final int INITIAL_VALUE_OF_FIELD = 12;
    public static final int MAX = 81;
    public static final int ONE = 1;
    public static final int NUMBER_FOR_ONE_LINE = 3;
    public static final int LENGTH_FOR_STRING = Pack.FILL[0].length();

    private int sizeOfField;
    private Set<Integer> listOfContains;
    private Map<Integer, Integer> randomList;
    private Map<Integer, ICard> cardInFieldGame;
    private List<ICard> packForGame;

    /**
     * startup of the objects
     */
    public Field() {
        this.sizeOfField = INITIAL_VALUE_OF_FIELD;
        this.cardInFieldGame = new TreeMap<>();
        this.randomList = new TreeMap<>();
        this.packForGame = new LinkedList<>();
        this.listOfContains = new TreeSet<>();
    }

    @Override
    public void startUp() {
        Map<Integer, ICard> packForTheGame = new TreeMap<>();
        rand();
        IPack IPack = new Pack();
        int i = 0;
        for (ICard card : IPack.getPack()) {
            packForTheGame.put(this.getRandomList().get(i), card);
            i++;
        }
        packForGame.addAll(packForTheGame.values());

        startUpOfField();
    }

    private Map<Integer, Integer> rand() {
        int[] tem = new int[MAX];
        boolean b;
        for (int key = 0; key < MAX; key++) {
            b = true;
            int element = (int) (Math.random() * MAX + ONE);
            for (int t = 0; t < MAX; t++) {
                if (element == tem[t] && key > 0) {
                    key = key - 1;
                    b = false;
                }
            }
            if (b) {

                this.getRandomList().put(key, element);

                tem[key] = element;
            }

        }
        return getRandomList();

    }

    private void startUpOfField() {
        for (int index = 0; index < sizeOfField; index++) {
            this.getCardInFieldGame().put(index, this.packForGame.get(index));

        }
    }

    @Override
    public void foundSet(ICard cardOne, ICard cardTwo, ICard cardThree) {
        TreeSet<Integer> keyOfCardInField = new TreeSet<>();
        for (Integer key : this.getCardInFieldGame().keySet()) {
            if (this.getCardInFieldGame().get(key).compareTo(cardOne)
                    || this.getCardInFieldGame().get(key).compareTo(cardTwo)
                    || this.getCardInFieldGame().get(key).compareTo(cardThree)) {
                keyOfCardInField.add(key);
                this.packForGame.remove(this.getCardInFieldGame().get(key));
            }
        }
        for (Integer key : keyOfCardInField) {
            this.getCardInFieldGame().remove(key);

        }
        fillField();
    }

    private void fillField() {
        LinkedList<ICard> listCardAreNotInFieldCards = new LinkedList<>();
        listCardAreNotInFieldCards.addAll(getUnusedCards());

        for (int index = 0; index < sizeOfField; index++) {
            if (this.getCardInFieldGame().get(index) == null
                    && !(listCardAreNotInFieldCards.isEmpty())) {
                this.getCardInFieldGame().put(index,
                        listCardAreNotInFieldCards.getFirst());
                listCardAreNotInFieldCards.removeFirst();
            } else if (this.getCardInFieldGame().get(index) == null
                    && listCardAreNotInFieldCards.isEmpty()) {
                this.getCardInFieldGame().remove(index);

            } else if (!(this.getCardInFieldGame().containsKey(index))
                    && !(listCardAreNotInFieldCards.isEmpty())) {
                this.getCardInFieldGame().put(index,
                        listCardAreNotInFieldCards.getFirst());
                listCardAreNotInFieldCards.removeFirst();

            }
        }

    }

    @Override
    public List<ICard> getCardsInField() {
        List<ICard> list = new LinkedList<>();
        list.addAll(this.getCardInFieldGame().values());
        return list;

    }

    @Override
    public void setSizeOfField(int size) {
        if (size != sizeOfField && size >= 3 && size <= getUnusedCards().size()) {
            this.cardInFieldGame.clear();
            this.sizeOfField = size;
            fillField();
        }
    }

    @Override
    public void changeCards(List<ICard> list) {
        for (int i = 0; i < list.size(); i++) {
            this.cardInFieldGame.put(i, list.get(i));
        }
    }

    @Override
    public List<ICard> getUnusedCards() {
        LinkedList<ICard> list = new LinkedList<>();
        list.addAll(this.packForGame);
        list.removeAll(this.getCardInFieldGame().values());
        return list;
    }

    @Override
    public int getSizeofField() {
        return getCardInFieldGame().size();
    }

    @Override
    public List<ICard> getAllCardsInGame() {
        return this.packForGame;
    }

    private Map<Integer, Integer> getRandomList() {
        return randomList;
    }

    @Override
    public Map<Integer, ICard> getCardInFieldGame() {
        return cardInFieldGame;
    }

    @Override
    public void clear() {
        packForGame.clear();
        this.cardInFieldGame.clear();
        this.packForGame.clear();
        this.sizeOfField = INITIAL_VALUE_OF_FIELD;
        startUp();
    }

    @Override
    public String toString() {
        return returnString();
    }

    private String returnAppend() {
        return "|  ";
    }

    private String returnString() {
        this.listOfContains.clear();
        StringBuilder field = new StringBuilder();
        field.append("\n");
        int t = 0;
        while (t != this.sizeOfField) {
            field.append(appendKeyInString()).append("\n");
            field.append(appendColorInString()).append("\n");
            field.append(appendFormInString()).append("\n");
            field.append(appendNumberOfComponents()).append("\n");
            field.append(appendFillingInString()).append("\n");
            t++;
            if (sizeOfField == listOfContains.size()) {
                break;
            }
        }
        return field.toString();
    }

    private String appendKeyInString() {
        StringBuilder field = new StringBuilder();
        int i = 0;
        for (Integer key : cardInFieldGame.keySet()) {
            if (!listOfContains.contains(key)) {
                double rest = LENGTH_FOR_STRING - 1;
                double me = rest / 2;
                rest = rest - me;
                for (int loop = 0; loop < me; loop++) {
                    field.append(" ");
                }
                field.append("[").append(key).append("]");
                for (int loop = 0; loop < rest; loop++) {
                    field.append(" ");
                }
                i++;
                if (i == NUMBER_FOR_ONE_LINE) {
                    break;
                }
            }
        }
        return field.toString();
    }

    private String appendColorInString() {
        int i = 0;
        StringBuilder field = new StringBuilder();
        for (Integer key : cardInFieldGame.keySet()) {
            if (!listOfContains.contains(key)) {
                int rest = LENGTH_FOR_STRING
                        - cardInFieldGame.get(key).getColor().toCharArray().length;
                int me = rest / 2;
                rest = rest - me;
                field.append("|");
                for (int loop = 0; loop < me; loop++) {
                    field.append(" ");
                }
                field.append(cardInFieldGame.get(key).getColor());
                for (int loop = 0; loop < rest; loop++) {
                    field.append(" ");
                }
                field.append(returnAppend());
                i++;
                if (i == NUMBER_FOR_ONE_LINE) {
                    break;
                }
            }
        }
        return field.toString();
    }

    private String appendFormInString() {
        int i = 0;
        StringBuilder field = new StringBuilder();
        for (Integer key : cardInFieldGame.keySet()) {
            if (!listOfContains.contains(key)) {
                int rest = LENGTH_FOR_STRING
                        - cardInFieldGame.get(key).getForm().toCharArray().length;
                int me = rest / 2;
                rest = rest - me;
                field.append("|");
                for (int loop = 0; loop < me; loop++) {
                    field.append(" ");
                }
                field.append(cardInFieldGame.get(key).getForm());
                for (int loop = 0; loop < rest; loop++) {
                    field.append(" ");
                }
                field.append(returnAppend());
                i++;
                if (i == NUMBER_FOR_ONE_LINE) {
                    break;
                }
            }
        }
        return field.toString();
    }

    private String appendNumberOfComponents() {
        int i = 0;
        StringBuilder field = new StringBuilder();
        for (Integer key : cardInFieldGame.keySet()) {
            if (!listOfContains.contains(key)) {
                int rest = LENGTH_FOR_STRING - 1;
                int me = rest / 2;
                rest = rest - me;
                field.append("|");
                for (int loop = 0; loop < me; loop++) {
                    field.append(" ");
                }
                field.append(cardInFieldGame.get(key).getNumberOfComponents());
                for (int loop = 0; loop < rest; loop++) {
                    field.append(" ");
                }
                field.append(returnAppend());
                i++;
                if (i == NUMBER_FOR_ONE_LINE) {
                    break;
                }
            }

        }
        return field.toString();
    }

    private String appendFillingInString() {
        int i = 0;
        StringBuilder field = new StringBuilder();
        for (Integer key : cardInFieldGame.keySet()) {
            if (!listOfContains.contains(key)) {
                int rest = LENGTH_FOR_STRING
                        - cardInFieldGame.get(key).getPanelFilling()
                        .toCharArray().length;
                int me = rest / 2;
                rest = rest - me;
                field.append("|");
                for (int loop = 0; loop < me; loop++) {
                    field.append(" ");
                }
                field.append(cardInFieldGame.get(key).getPanelFilling());
                for (int loop = 0; loop < rest; loop++) {
                    field.append(" ");
                }
                field.append(returnAppend());
                listOfContains.add(key);
                i++;
                if (i == NUMBER_FOR_ONE_LINE) {
                    break;
                }
            }
        }
        return field.toString();
    }


}
