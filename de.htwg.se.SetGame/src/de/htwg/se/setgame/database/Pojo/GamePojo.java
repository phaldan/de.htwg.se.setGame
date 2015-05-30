package de.htwg.se.setgame.database.Pojo;

import de.htwg.se.setgame.model.ICardList;
import de.htwg.se.setgame.model.IGame;
import de.htwg.se.setgame.model.IPlayer;

import java.util.List;

/**
 * Created by Pavan on 22/05/2015.
 */
public class GamePojo implements IGame {
   /* which property files are suppose to be added here ?? */
   private IPlayer player=null;
   private ICardList cardList=null;
   private int id;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

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

   /**
    * @return Return list of IPlayer instance
    */
   @Override
   public List<IPlayer> getPlayers() {
      return null;
   }

   /**
    * @param player Add IPlayer instance
    */
   @Override
   public void addPlayer(IPlayer player) {

   }

   /**
    * @param player IPlayer instance
    * @return Return true on success;
    */
   @Override
   public boolean removePlayer(IPlayer player) {
      return false;
   }

   /**
    * @return Return ICardList instance for field cards
    */
   @Override
   public ICardList getFieldCardList() {
      return null;
   }

   /**
    * @param list ICardList instance
    */
   @Override
   public void setFieldCardList(ICardList list) {

   }

   /**
    * @return Return ICardList instance for unused cards
    */
   @Override
   public ICardList getUnusedCardList() {
      return null;
   }

   /**
    * @param list ICardList instance
    */
   @Override
   public void setUnusedCardList(ICardList list) {

   }

   /**
    * @return Return IPlayer instance
    */
   @Override
   public IPlayer getWinner() {
      return null;
   }

   /**
    * @param player IPlayer instance
    */
   @Override
   public void setWinner(IPlayer player) {

   }
}
