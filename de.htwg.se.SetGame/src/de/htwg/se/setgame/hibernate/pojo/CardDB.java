package de.htwg.se.setgame.hibernate.pojo;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Table(name="CARD_DB")
public class CardDB {
    private int id;
    private String color;
    private String form;
    private String panelFilling;
    private Integer count;


    @Id
    @GeneratedValue
    @Column(name="CARD_ID")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Column (name = "CARD_FORM")
    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Column (name = "CARD_COLOR")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Column (name = "CARD_FILLING")
    public String getPanelFilling() {
        return panelFilling;
    }

    public void setPanelFilling(String panelFilling) {
        this.panelFilling = panelFilling;
    }

    @Column (name = "CARD_COUNT")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

        @ManyToOne
        @JoinColumn(name = "CARDLIST_ID")
        private CardListDB  cardListDB;

}
