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

    private HibernateBase hibernate;

    /**
     */
    public HibernateManager() {
        Configuration cfg = new Configuration();
        Properties prop = cfg.configure().getProperties();
        ServiceRegistry service = new StandardServiceRegistryBuilder().applySettings(prop).build();
        SessionFactory factory = cfg.buildSessionFactory(service);
        hibernate = new HibernateBase(factory);
    }

    @Override
    public CardDao getCard() {
        return new CardDaoHibernate(hibernate);
    }

    @Override
    public CardListDao getCardList() {
        return new CardListDaoHibernate(hibernate);
    }

    @Override
    public GameDao getGame() {
        return new GameDaoHibernate(hibernate);
    }

    @Override
    public PlayerDao getPlayer() {
        return new PlayerDaoHibernate(hibernate);
    }
}
