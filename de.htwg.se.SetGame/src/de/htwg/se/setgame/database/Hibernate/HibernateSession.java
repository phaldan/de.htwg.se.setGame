package de.htwg.se.setgame.database.Hibernate;

import de.htwg.se.setgame.database.ISession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSession implements ISession {

    @Override

    public Session configureSession() {
        System.out.println("#-> configureSession()");
        System.out.println("#    set 'session' to null");
        Session session=null;
       try {
           System.out.println("#    TRY-BLOCK: new Configuration() ");
           Configuration cfg=new Configuration();
           System.out.println("#    TRY-BLOCK: cfg.configure(hibernate.cfg.xml); ");
           cfg.configure("hibernate.cfg.xml");
           System.out.println("#    TRY-BLOCK: factory=cfg.buildSessionFactory(); ");
           SessionFactory factory=cfg.buildSessionFactory();
           System.out.println("#    TRY-BLOCK: session=factory.openSession();");
           session=factory.openSession();
       }
       catch (Throwable ex) {
           System.err.println("Initial SessionFactory creation failed." + ex);
           throw new ExceptionInInitializerError(ex);
       }
        return session;

    }
}
