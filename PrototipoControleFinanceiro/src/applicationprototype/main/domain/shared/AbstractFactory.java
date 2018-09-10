package applicationprototype.main.domain.shared;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Date;
import java.util.Properties;

public abstract class AbstractFactory {
	protected Properties properties = new Properties();
	protected final static String RESOURCES_HOME = System.getProperty("user.dir")+"/src/applicationprototype/resource/";
	protected static String targetClass;
	
	
	public Properties getProperties() {
		return properties;
	}
		
	public abstract Constructor create(String target) throws IOException, NoSuchMethodException, SecurityException, ClassNotFoundException;

}
