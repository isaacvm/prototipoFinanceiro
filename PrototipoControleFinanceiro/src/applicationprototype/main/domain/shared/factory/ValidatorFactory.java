package applicationprototype.main.domain.shared.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;

import applicationprototype.main.domain.shared.AbstractFactory;
import applicationprototype.main.domain.shared.AbstractFinancialMovimentBuilder;
import applicationprototype.main.domain.shared.AbstractValidator;

public class ValidatorFactory extends AbstractFactory{

	public ValidatorFactory() throws IOException {
		loadProperties();
	}

	private void loadProperties() throws IOException {
		properties.load(new FileInputStream(
				RESOURCES_HOME + "ValidationFactory.properties"));
	}

	@Override
	public Constructor create(String toEntity) throws IOException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		this.targetClass = toEntity;
		String directory = properties.getProperty(targetClass);
		Class reflect = Class.forName(directory);
		return reflect.getConstructor(AbstractFinancialMovimentBuilder.class);
	}
}