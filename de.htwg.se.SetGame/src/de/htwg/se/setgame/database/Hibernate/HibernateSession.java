package de.htwg.se.setgame.database.Hibernate;

import de.htwg.se.setgame.database.ISession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSession implements ISession {

    @Override

    public Session configureSession() {

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
       Session session=factory.openSession();
        return session;

    }
}
