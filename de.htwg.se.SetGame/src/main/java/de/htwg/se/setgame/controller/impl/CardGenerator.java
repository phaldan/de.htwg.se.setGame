package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.model.impl.Option;
import de.htwg.se.setgame.util.persistence.CardDao;
import de.htwg.se.setgame.util.persistence.CardOptionDao;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Philipp Daniels
 */
public class CardGenerator {

    protected static final String COLOR_1 = "red";
    protected static final String COLOR_2 = "green";
    protected static final String COLOR_3 = "purple";
    protected static final String[] COLOR = {COLOR_1, COLOR_2, COLOR_3};
    protected static final String FORM_1 = "ovally";
    protected static final String FORM_2 = "wave";
    protected static final String FORM_3 = "balk";
    protected static final String[] FORM = {FORM_1, FORM_2, FORM_3};
    protected static final String FILL_1 = "halffill";
    protected static final String FILL_2 = "fill";
    protected static final String FILL_3 = "empty";
    protected static final String[] FILL = {FILL_1, FILL_2, FILL_3};
    protected static final Integer COUNT_1 = 1;
    protected static final Integer COUNT_2 = 2;
    protected static final Integer COUNT_3 = 3;
    protected static final Integer[] COUNT = {COUNT_1, COUNT_2, COUNT_3};

    private CardDao dao;
    private CardOptionDao cardOptionDao;
    private CardOptions cardOptions;

    /**
     * @param cardDao Instance of CardDao
     */
    protected CardGenerator(CardDao cardDao, CardOptionDao cardOptionDao, CardOptions cardOptions) {
        this.dao = cardDao;
        this.cardOptionDao = cardOptionDao;
        this.cardOptions = cardOptions;
    }

    protected void generate(ICardList cardList) {
        List<IOption> options = cardOptions.getValues();

        int[] increaseIndex = new int[options.size()];
        int countCards = calculateNumberOfCards(options, increaseIndex);

        int[] indexes = new int[options.size()];
        int optionIndex = 0;
        for (int i = 0; i < countCards; i++) {
            optionIndex = increaseOptionIndex(indexes, optionIndex, options);
            ICard card = createCard(cardList);
            createCardOptions(options, card, indexes);
            changeIndexes(i, options, increaseIndex, indexes);
        }
    }

    private int calculateNumberOfCards(List<IOption> options, int[] increaseIndex) {
        int countCards = 1;
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getOptionValues().size() > 0) {
                increaseIndex[i] = countCards;
                countCards = countCards * options.get(i).getOptionValues().size();
            }
        }
        return countCards;
    }

    private int increaseOptionIndex(int[] indexes, int index, List<IOption> options) {
        return (indexes[index] + 1 > options.get(index).getOptionValues().size()) ? index + 1 : index;
    }

    private ICard createCard(ICardList list) {
        ICard card = dao.create();
        card.setCardList(list);
        list.getCards().add(card);
        dao.add(card);
        return card;
    }

    private void createCardOptions(List<IOption> options, ICard card, int[] indexes) {
        for (int j = 0; j < options.size(); j++) {
            Object[] values = options.get(j).getOptionValues().toArray();
            createOption(card, (IOptionValue) values[indexes[j]]);
        }
        dao.update(card);
    }

    private void createOption(ICard card, IOptionValue option) {
        ICardOption cardOption = cardOptionDao.create();
        card.getCardOptions().add(cardOption);

        cardOption.setCard(card);
        cardOption.setOption(option);

        cardOptionDao.add(cardOption);
    }

    private void changeIndexes(int i, List<IOption> options, int[] increaseIndex, int[] indexes) {
        for (int j = 0; j < options.size(); j++) {
            if ((i + 1) % increaseIndex[j] == 0) {
                indexes[j]++;
            }
            if (indexes[j] == options.get(j).getOptionValues().size()) {
                indexes[j] = 0;
            }
        }
    }
}
