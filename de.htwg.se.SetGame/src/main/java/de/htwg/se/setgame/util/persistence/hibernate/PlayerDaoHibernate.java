package de.htwg.se.setgame.util.persistence.hibernate;

import de.htwg.se.setgame.model.IPlayer;
import de.htwg.se.setgame.util.persistence.PlayerDao;
import de.htwg.se.setgame.util.persistence.hibernate.pojo.PlayerHibernate;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

/**
 * @author Philipp Daniels
 */
public class PlayerDaoHibernate implements PlayerDao {

    private static final Logger LOGGER = Logger.getLogger(PlayerDao.class);

    private HibernateBase db;

    protected PlayerDaoHibernate(HibernateBase db) {
        this.db = db;
    }

    @Override
    public IPlayer create() {
        return new PlayerHibernate();
    }

    @Override
    public IPlayer getByName(String name) {
        IPlayer player = (IPlayer) db.getCriteria(PlayerHibernate.class)
                .createAlias("game", "g", JoinType.LEFT_OUTER_JOIN)
                .createAlias("g.players", "p", JoinType.LEFT_OUTER_JOIN)
                .createAlias("g.fieldCardList", "f", JoinType.LEFT_OUTER_JOIN)
                .createAlias("f.cards", "fc", JoinType.LEFT_OUTER_JOIN)
                .createAlias("g.unusedCardList", "u", JoinType.LEFT_OUTER_JOIN)
                .createAlias("u.cards", "uc", JoinType.LEFT_OUTER_JOIN)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
        db.close();
        return player;
    }

    @Override
    public void add(IPlayer player) {
        db.persist(player);
        LOGGER.debug("Add new: " + player.getId());
    }

    @Override
    public void update(IPlayer player) {
        db.persist(player);
        LOGGER.debug("Update existing: " + player.getId());
    }
}
