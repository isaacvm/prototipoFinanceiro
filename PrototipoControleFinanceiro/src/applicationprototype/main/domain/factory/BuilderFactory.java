package applicationprototype.main.domain.factory;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Date;

import applicationprototype.main.domain.shared.CoreFactory;

public class BuilderFactory extends CoreFactory{

	private BuilderFactory() {	
	}
	
	public static Constructor createConstructor() throws IOException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		String directory = properties.getProperty(targetClass);
		Class reflect = Class.forName(directory);
		return reflect.getConstructor(Date.class,String.class,Number.class);
	}
}