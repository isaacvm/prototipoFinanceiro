package applicationprototype.main.domain.shared;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import applicationprototype.main.domain.shared.factory.BuilderFactory;
import applicationprototype.main.domain.shared.factory.ValidatorFactory;

public abstract class AbstractFinancialMovimentBuilder {

	protected Date date;
	protected String notes;
	protected String type;
	protected Number value;
	protected AbstractValidator validator;

	public AbstractFinancialMovimentBuilder(Date date, String type, Number value)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException {

		this.date = date;
		this.type = type;
		this.value = value;
		initValidation();
	}
	

	private void initValidation() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		AbstractFactory vf = new ValidatorFactory();
		Properties validatorProperties = vf.getProperties();
		AbstractFactory bf = new BuilderFactory();
		Properties BuilderProperties = bf.getProperties();
		if (!isPropertiesEquals(validatorProperties, BuilderProperties))
			throw new ClassNotFoundException(
					"Os arquivos de propriedades da fábrica de validators e builders são diferentes");
		Set<Object> keys = validatorProperties.keySet();
		Iterator<Object> i = keys.iterator();

		String baseKey = this.getClass().getSimpleName().substring(0, this.getClass().getSimpleName().length()-7);
		while (i.hasNext()) {
			String k = (String) i.next();
			if(k.equals(baseKey)) {
				Constructor create = vf.create(k);
				validator = (AbstractValidator) create.newInstance(this);
				break;
			}
		}			
//			addBuilderHandler(vc);
		
		//this.first.handleRequest(this);
	}

	private final boolean isPropertiesEquals(final Properties validatorProperties, final Properties builderProperties) {
		if (validatorProperties == null || builderProperties == null)
			return false;
		if (validatorProperties.size() != builderProperties.size())
			return false;
		final Iterator<Object> vKeySet = validatorProperties.keySet().iterator();
		final Set<Object> bKeySet = builderProperties.keySet();
		while (vKeySet.hasNext()) {
			if (!bKeySet.contains(vKeySet.next())) {
				return false;
			}
		}
		return true;

	}

	protected Date getDate() {
		return date;
	}

	protected String getNotes() {
		return notes;
	}

	protected String getType() {
		return type;
	}

	protected Number getValue() {
		return value;
	}

	public abstract Entity build();

}
