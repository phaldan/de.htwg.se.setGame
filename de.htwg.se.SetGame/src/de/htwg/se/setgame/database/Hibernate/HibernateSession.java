package de.htwg.se.setgame.database.Hibernate;
import org.hibernate.*;
import de.htwg.se.setgame.database.ISession;

import javax.jms.Session;

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
