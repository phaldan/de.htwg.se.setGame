package de.htwg.se.setgame.database;

public interface ISession{


    // Session particular to database
        org.hibernate.Session configureSession();
        }