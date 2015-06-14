package de.htwg.se.setgame.database.couchDB;

import com.fourspaces.couchdb.Database;
import com.fourspaces.couchdb.Document;


/**
 * Created by Pavan on 07/06/2015.
 */
public class Couch_BasicOperations {


    public static void addCard(Object obj,Database db){

        Document doc=new Document();
        doc.put("Card",obj);
        doc.setId("CouchBasicADDCARD");
        try {
            db.saveDocument(doc);
        } catch (Exception e) {
            throw e;
        }

    }


    public static void addCardList(Object obj,Database db){

        Document doc=new Document();
        doc.put("CardList",obj);
        doc.setId("Couch_BasicAddCardList");
        try {
            db.saveDocument(doc);
        } catch (Exception e) {
            throw e;
        }

    }


    public static void addGame(Object obj,Database db){

        Document doc=new Document();
        doc.put("Game", obj);
        doc.setId("CouchBasicAddGame3");
        try {
            db.saveDocument(doc);
        } catch (Exception e) {
            throw e;
        }

    }

    public static void addPlayer(Object obj,Database db){

        Document doc=new Document();
        doc.put("Player",obj);
        doc.setId("CouchBasicAddPlayer2");
        try {
            db.saveDocument(doc);
        } catch (Exception e) {
            throw e;
        }

    }
    public static void updateCard(Object obj,Database db){
        Document doc=new Document();
        try {
            //doc=  db.getDocument("setgamedb/8efa9ba30488c8cb737f21957c003634");

            db.getDocument("Couch_BasicADDCARD");
            doc.put("Card",obj);
            db.saveDocument(doc);
        } catch (Exception e) {
            throw e;
        }

    }

    public static void updateCardList(Object obj,Database db){
        Document doc=new Document();
        try {
            //doc=  db.getDocument("setgamedb/8efa9ba30488c8cb737f21957c003634");

            db.getDocument("Cardlist4");
            doc.put("CardList",obj);
            db.saveDocument(doc);
        } catch (Exception e) {
            throw e;
        }

    }

    public static void updateGame(Object obj,Database db){
        Document doc=new Document();
        try {
            db.getDocument("Game");   //Here we have to enter the id
            doc.put("Game",obj);
            db.saveDocument(doc);
        } catch (Exception e) {
            throw e;
        }

    }

    public static void updatePlayer(Object obj,Database db){
        Document doc=new Document();
        try {
            db.getDocument("CouchBasicAddPlayer");   //Here we have to enter the id
            doc.put("PLayer",obj);
            db.saveDocument(doc);
        } catch (Exception e) {
            throw e;
        }

    }

  /*  public static Document getDocument(Object docPassed){
        Document doc = new Document();
        doc.put("", docPassed);

        doc.put("Language", language);
        return doc;
    }*/


}
