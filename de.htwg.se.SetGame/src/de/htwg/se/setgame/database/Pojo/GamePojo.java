package de.htwg.se.setgame.database.Pojo;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IPlayer;

/**
 * Created by Pavan on 22/05/2015.
 */
public class GamePojo {
   /* which property files are suppose to be added here ?? */
   private IPlayer player=null;
   private ICardList cardList=null;
   public IPlayer getPlayer() {
      return player;
   }

   public void setPlayer(IPlayer player) {
      this.player = player;
   }

   public ICardList getCardList() {
      return cardList;
   }

   public void setCardList(ICardList cardList) {
      this.cardList = cardList;
   }
}
