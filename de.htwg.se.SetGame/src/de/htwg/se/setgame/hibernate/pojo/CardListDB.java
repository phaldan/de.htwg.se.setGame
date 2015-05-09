package de.htwg.se.setgame.hibernate.pojo;
import de.htwg.se.setgame.model.ICard;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="CARDLIST_DB")
public class CardListDB {

    @Id
    @GeneratedValue
    @Column(name="CARDLIST_ID")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private List<ICard> cards = new LinkedList<>();

    @Column (name = "CARDLIST_CARDS")
    public void addCard(ICard card) {
        cards.add(card);
    }
    public List<ICard> getCards() {
        return cards;
    }
}
