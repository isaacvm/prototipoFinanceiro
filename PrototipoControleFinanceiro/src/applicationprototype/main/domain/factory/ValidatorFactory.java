package applicationprototype.main.domain.factory;

import java.io.IOException;
import java.lang.reflect.Constructor;

import applicationprototype.main.domain.shared.AbstractFinancialMovimentBuilder;
import applicationprototype.main.domain.shared.CoreFactory;

public class ValidatorFactory extends CoreFactory{

	private ValidatorFactory() {
	}

	public static Constructor createConstructor() throws IOException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		String directory = properties.getProperty(targetClass);
		Class reflect = Class.forName(directory);
		return reflect.getConstructor(AbstractFinancialMovimentBuilder.class);
	}
}