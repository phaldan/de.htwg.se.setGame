package de.htwg.se.setgame.util.persistence.db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import de.htwg.se.setgame.util.persistence.Hibernate.DaoManager_Operation;
import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.DaoManager;
import de.htwg.se.setgame.util.persistence.PlayerDao;

/**
 * Created by Pavan on 03/06/2015.
 */
public class Player_db4o implements PlayerDao{

    final static String DB4OFILENAME = "Player_db4o.db";
    private DaoManager daoManager;


    /**
     * @return Return new IPlayer instance
     */
    @Override
    public IPlayer create() {
        IPlayer player = null;
        daoManager = new DaoManager_Operation();
        player = (IPlayer) daoManager.getPlayer();
        return player;
    }

    /**
     * @param name Player name
     * @return Return IPlayer instance with IGame
     */
    @Override
    public IPlayer getByName(String name) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
        IPlayer playerFound = null; //this.create();
        IPlayer playerPrototype = null;
        playerPrototype = this.create();
        playerPrototype.setName(name);
        playerPrototype.setScore(0);
        playerPrototype.setGame(null);

        try {
            ObjectSet <IPlayer> result = db.queryByExample(playerPrototype);
            if (result.isEmpty() == false) {
                playerFound = (IPlayer) result.next();
            }
        }
        catch (Exception e){
            throw e;
        }
        finally {
            db.close();
        }

        return playerFound;
    }

    /**
     * Insert new entry
     *
     * @param player IPlayer instance
     */
    @Override
    public void add(IPlayer player) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);

        try {
            db.store(player);
            System.out.println("Player_db40: Added player " + player);
        }
        catch (Exception e){
            throw e;
        }
        finally {
            db.close();
        }
    }

    /**
     * Update existent entry
     *
     * @param player IPlayer instance
     */
    @Override
    public void update(IPlayer player) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);

        try {
          /*  IPlayer playerPrototype = null;
            playerPrototype = this.create();
            playerPrototype.setName(player.getName());
            playerPrototype.setScore(0);
            playerPrototype.setGame(null);

            ObjectSet <IPlayer> result = db.queryByExample(playerPrototype);
            System.out.println("##### PLAYER_DB40:  update() : before if###");
            if(result.isEmpty() == false){
                System.out.println("##### PLAYER_DB40:  update() : IN if###");
                IPlayer playerFound = (IPlayer) result.next();
                playerFound.setGame(player.getGame());
                playerFound.setScore(player.getScore());
                db.store(playerFound);
                System.out.println("Updated Player " + player);
            }
            */
            db.store(player);
        }
        catch (Exception e){
            throw e;
        }
        finally {
            db.close();
        }
    }
}
