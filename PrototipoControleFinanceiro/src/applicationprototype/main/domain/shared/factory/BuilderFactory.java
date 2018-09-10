package applicationprototype.main.domain.shared.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Date;

import applicationprototype.main.domain.shared.AbstractFactory;

public class BuilderFactory extends AbstractFactory{

	public BuilderFactory() throws IOException {
		loadProperties();
	}

	private void loadProperties() throws IOException {
		properties.load(new FileInputStream(
				RESOURCES_HOME + "BuildFactory.properties"));
	}

	@Override
	public Constructor create(String toEntity) throws IOException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		this.targetClass = toEntity;
		String directory = properties.getProperty(targetClass);
		Class reflect = Class.forName(directory);
		return reflect.getConstructor(Date.class,String.class,Number.class);
	}
}