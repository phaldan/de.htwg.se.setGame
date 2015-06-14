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

    private SessionFactory factory;

    public HibernateManager() {
        Configuration cfg = new Configuration();
        Properties prop = cfg.configure().getProperties();
        ServiceRegistry service = new StandardServiceRegistryBuilder().applySettings(prop).build();
        factory = cfg.buildSessionFactory(service);
    }

    @Override
    public CardDao getCard() {
        return new Card_dbOperation();
    }

    @Override
    public CardListDao getCardList() {
        return new CardList_dbOperation();
    }

    @Override
    public PlayerDao getPlayer() {
        return new Player_dbOperation();
    }

    @Override
    public GameDao getGame() {
        return new Game_dbOperation();
    }
}
