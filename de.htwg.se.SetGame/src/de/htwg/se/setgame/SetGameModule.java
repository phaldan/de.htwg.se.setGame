package de.htwg.se.setgame;

import com.google.inject.AbstractModule;
import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.controller.impl.SetController;
import de.htwg.se.setgame.model.IField;
import de.htwg.se.setgame.model.impl.Field;

public class SetGameModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IField.class).to(Field.class);
		bind(IController.class).to(SetController.class);
	}

}
