package de.htwg.se.setgame;

import com.google.inject.AbstractModule;
import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.controller.impl.SetController;
import de.htwg.se.setgame.util.persistence.Hibernate.HibernateSession;
import de.htwg.se.setgame.util.persistence.ISession;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.model.impl.ModelFactoryImpl;

/**
 * @author Philipp
 */
public class SetGameModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IController.class).to(SetController.class);
		bind(ModelFactory.class).to(ModelFactoryImpl.class);
		// binding ISession with Hibernate Session
		bind(ISession.class).to(HibernateSession.class);
	}

}
