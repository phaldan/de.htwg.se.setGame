package de.htwg.se.setgame.database.db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import de.htwg.se.setgame.database.Hibernate.DaoManager_Operation;
import de.htwg.se.setgame.model.ICard;
import de.htwg.se.setgame.util.persistence.CardDao;
import de.htwg.se.setgame.util.persistence.DaoManager;

/**
 * Created by Pavan on 03/06/2015.
 */
public class Card_db4o implements CardDao {

    final static String DB4OFILENAME = "Card_db40.db";
    private DaoManager daoManager;

    /*
    public static void accessDb40() {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
        try {
            // do something with db4o
        } finally {
            db.close();
        }
    }
    */


    public ICard create(){
        ICard card = null;
        daoManager = new DaoManager_Operation();
        card =(ICard) daoManager.getCard();
        return card;
    }


    public Integer add(ICard card){
        Integer retDefault = 0;
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);

        try {
            db.store(card);
            System.out.println("Added " + card);
        }
        catch (Exception e){
            throw e;
        }
        finally {
            db.close();
        }
        return retDefault;
    }


    public void update(ICard card){
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
        try {
           // db.store(card);
            ICard cardProto = null;
            cardProto = this.create();
            cardProto.setColor(card.getColor());
            cardProto.setForm(card.getForm());
            //cardProto.setPanelFilling(card.getPanelFilling());
            ObjectSet result = db.queryByExample(cardProto);
            System.out.println("##### CARD_DB40:  update() : before if###");
            if(result.isEmpty() == false) {
                System.out.println("##### CARD_DB40:  update() : IN if###");
                ICard cardFound = (ICard) result.next();
                // do updates regarding card
                //cardFound.setColor(card.getColor());
                cardFound.setPanelFilling(card.getPanelFilling());
                cardFound.setCardList(card.getCardList());
                //cardFound.setNumberOfComponents(card.getNumberOfComponents());
                db.store(cardFound);
                System.out.println("Updated card" + card);
            }
        }
        catch (Exception e){
            throw e;
        }
        finally {
            db.close();
        }




    }



}
