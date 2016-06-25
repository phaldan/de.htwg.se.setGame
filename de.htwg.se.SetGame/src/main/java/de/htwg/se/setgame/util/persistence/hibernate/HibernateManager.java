package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.util.persistence.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

/**
 * @author Philipp Daniels
 */
public class HibernateManager implements DaoManager {

    private HibernateBase db;

    private static SessionFactory createFactory() {
        Configuration cfg = new Configuration();
        Properties prop = cfg.configure().getProperties();
        ServiceRegistry service = new StandardServiceRegistryBuilder().applySettings(prop).build();
        return cfg.buildSessionFactory(service);
    }

    /**
     */
    public HibernateManager() {
        this(createFactory());
    }

    protected HibernateManager(SessionFactory factory) {
        db = new HibernateBase(factory);
    }

    @Override
    public CardDao getCard() {
        return new CardDaoHibernate(db);
    }

    @Override
    public CardListDao getCardList() {
        return new CardListDaoHibernate(db);
    }

    @Override
    public GameDao getGame() {
        return new GameDaoHibernate(db);
    }

    @Override
    public PlayerDao getPlayer() {
        return new PlayerDaoHibernate(db);
    }

    @Override
    public void exit() {
        db.close();
    }
}
