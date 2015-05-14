package de.htwg.se.setgame.database;
import org.hibernate.*;



public interface ISession{


    // Session particular to database
        Session configureSession();
        }