package de.htwg.se.setgame.util.persistence;
import org.hibernate.*;



public interface ISession{


    // Session particular to database
        Session configureSession();
        }