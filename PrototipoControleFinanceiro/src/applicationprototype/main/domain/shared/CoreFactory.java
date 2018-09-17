package applicationprototype.main.domain.shared;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;

import applicationprototype.main.domain.factory.BuilderFactory;
import applicationprototype.main.domain.factory.PersistenceFactory;
import applicationprototype.main.domain.factory.ValidatorFactory;

/*
 * MOTIVAÇÃO
 * As fábricas foram criadas para fornecer a possibilidade de criação das 
 * entidades de forma dinâmica, reduzindo o acoplamento. Todas as entidades tem suas classes
 * criadas através do padrão factory.
 */
public abstract class CoreFactory {
	protected static Properties properties = new Properties();
	protected static String RESOURCES_HOME = System.getProperty("user.dir") + "\\src\\applicationprototype\\resource\\CoreFactory.properties";
	protected static String targetClass;

	public static final Properties getProperties() {
		return properties;
	}

	public static Constructor create(String param) throws IOException{
		targetClass = param.toLowerCase();
		properties.load(new FileInputStream(RESOURCES_HOME));
		return createInstance();
	}

	static Constructor createInstance() {
		String[] split = new String[2];
		split = targetClass.split(java.util.regex.Pattern.quote("."));
		String key = (split.length > 1) ? split[1] : split[0];
		try {
			switch (key.toLowerCase()) {
			case "builder":
				return BuilderFactory.createConstructor();

			case "validation":
				return ValidatorFactory.createConstructor();

			case "repository":
				return PersistenceFactory.createConstructor();
			
			case "init":
				return createContext();
			default:
				throw new IllegalArgumentException("Parâmetro não encontrado pela Factory");
			}
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static Constructor createContext() throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		String directory = properties.getProperty(targetClass);
		Class<?> reflect = Class.forName(directory);
		return reflect.getConstructor();
	}
}