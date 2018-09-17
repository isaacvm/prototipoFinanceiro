package applicationprototype.main.domain.factory;

import java.lang.reflect.Constructor;

import applicationprototype.main.domain.shared.CoreFactory;
import applicationprototype.main.infrastructure.persistence.IContext;

public class PersistenceFactory extends CoreFactory {

	private PersistenceFactory() {
		
	}
	
	public static Constructor createConstructor() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		String directory = properties.getProperty(targetClass);
		Class<?> reflect = Class.forName(directory);
		return reflect.getConstructor(IContext.class);
	}

}
