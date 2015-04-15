package de.htwg.se.setgame;

import com.google.inject.AbstractModule;
import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.controller.impl.SetController;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.model.impl.ModelFactoryImpl;
import de.htwg.se.setgame.persistence.IPackDAO;
import de.htwg.se.setgame.persistence.db4o.PackDb4oDAO;

/**
 * @author Philipp
 */
public class SetGameModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IController.class).to(SetController.class);
		bind(ModelFactory.class).to(ModelFactoryImpl.class);
		bind(IPackDAO.class).to(PackDb4oDAO.class);
	}

}
