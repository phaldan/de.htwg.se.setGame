package de.htwg.se.setgame.model.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

    private int sizeOfField;
    private Map<Integer, Integer> randomList;
    private Map<Integer, ICard> cardInFieldGame;
    private List<ICard> packForGame;
    private IPack pack;

    /**
     * startup of the objects
     */
    public Field(IPack pack) {
        this.pack = pack;

        sizeOfField = INITIAL_VALUE_OF_FIELD;
        cardInFieldGame = new TreeMap<>();
        randomList = new TreeMap<>();
        packForGame = new LinkedList<>();
    }

    @Override
    public void startUp() {
        rand();

        Map<Integer, ICard> packForTheGame = new TreeMap<>();
        int i = 0;
        for (ICard card : pack.getPack()) {
            packForTheGame.put(getRandomList().get(i), card);
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
                getRandomList().put(key, element);
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
        return new LinkedList<>(getCardInFieldGame().values());
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
        cardInFieldGame.clear();
        packForGame.clear();
        sizeOfField = INITIAL_VALUE_OF_FIELD;
        startUp();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (ICard card : getCardsInField()) {
            builder.append(card).append("\n");
        }
        return builder.toString();
    }
}
