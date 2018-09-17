package applicationprototype.main.domain.shared;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import applicationprototype.main.domain.factory.BuilderFactory;
import applicationprototype.main.domain.factory.ValidatorFactory;
/*
 * MOTIVA��O
 * Esta classe usa o padr�o Build para criar classes complexas. Neste prot�tipo as entidades
 * foram criadas como classes complexas por terem atributos obrigat�rios e n�o obrigat�rios,
 * objetos de valor associado, e uma valida��o na cria��o de cada inst�ncia.
 */
public abstract class AbstractFinancialMovimentBuilder {

	protected Date date;
	protected String notes;
	protected String type;
	protected double value;
	protected AbstractValidator validator;

	public AbstractFinancialMovimentBuilder(final Date date,final String type,final double value)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException {

		this.date = date;
		this.type = type;
		this.value = value;
		initValidation();
	}
	

	private void initValidation() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		String base = this.getClass().getSimpleName().substring(0, this.getClass().getSimpleName().length()-7);
		base = base.concat(".validator").toLowerCase();
		validator = (AbstractValidator) CoreFactory.create(base).newInstance(this);
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

	protected double getValue() {
		return value;
	}

	public abstract IEntity build();

}
