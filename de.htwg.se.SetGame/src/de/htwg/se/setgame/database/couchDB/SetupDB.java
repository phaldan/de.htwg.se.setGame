package de.htwg.se.setgame.database.couchDB;

import com.fourspaces.couchdb.Database;
import com.fourspaces.couchdb.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Pavan on 07/06/2015.
 */
public class SetupDB {
    private Session dbSession ;
    private Database db;
    private Database retreiveExistingdb;
    List<String> list;
    Iterator<String> iterator;


    private void init(){
        list=new ArrayList<String>();

    }


    public  Database setDatabaseSession(String dbName){
       init();
        dbSession = new Session("localhost", 5984);
       list= dbSession.getDatabaseNames();
        iterator=list.iterator();
        while(iterator.hasNext()){
           if(iterator.next().toString().equalsIgnoreCase(dbName)){
               return dbSession.getDatabase(dbName);
           }
        }
        if(list.contains(dbName)){
            db=dbSession.getDatabase(dbName);
            return db;
        }
        if(retreiveExistingdb!=null){
            return retreiveExistingdb;
          }
         else {
            db = dbSession.createDatabase(dbName);
            if (db == null)
                db = dbSession.getDatabase(dbName);
            return db;
        }
    }

}
