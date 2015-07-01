package de.htwg.se.setgame;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import de.htwg.se.setgame.controller.*;
import de.htwg.se.setgame.controller.impl.cpu.*;
import de.htwg.se.setgame.controller.impl.SetController;
import de.htwg.se.setgame.model.ModelFactory;
import de.htwg.se.setgame.model.impl.ModelFactoryImpl;
import de.htwg.se.setgame.util.persistence.DaoManager;
import de.htwg.se.setgame.util.persistence.couchDb.CouchDbManager;
import de.htwg.se.setgame.util.persistence.db4o.Db4oManager;

/**
 * @author Philipp Daniels
 */
public class SetGameModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IController.class).to(SetController.class);
		bind(ModelFactory.class).to(ModelFactoryImpl.class);
		bind(DaoManager.class).to(CouchDbManager.class);

		Multibinder<CpuPlayer> cpuBinder = Multibinder.newSetBinder(binder(), CpuPlayer.class);
		cpuBinder.addBinding().to(CpuEasy.class);
		cpuBinder.addBinding().to(CpuNormal.class);
		cpuBinder.addBinding().to(CpuHard.class);
	}
}
