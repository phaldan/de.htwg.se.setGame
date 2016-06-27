package de.htwg.se.setgame.controller.impl;

import de.htwg.se.setgame.model.*;
import de.htwg.se.setgame.model.impl.Option;
import de.htwg.se.setgame.util.persistence.CardDao;
import de.htwg.se.setgame.util.persistence.CardOptionDao;
import de.htwg.se.setgame.util.persistence.DaoManager;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Philipp Daniels
 */
public class CardGenerator {

    private CardDao dao;
    private CardOptionDao cardOptionDao;
    private CardOptions cardOptions;

    /**
     * @param dao Instance of DaoManager
     */
    protected CardGenerator(DaoManager dao) {
        this.dao = dao.getCard();
        this.cardOptionDao = dao.getCardOption();
        this.cardOptions = new CardOptions(dao);
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
