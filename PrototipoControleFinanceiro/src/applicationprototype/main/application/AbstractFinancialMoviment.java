package applicationprototype.main.application;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;

import applicationprototype.main.domain.factory.BuilderFactory;
import applicationprototype.main.domain.shared.AbstractFinancialMovimentBuilder;
import applicationprototype.main.domain.shared.IEntity;
import applicationprototype.main.domain.shared.IValueObject;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;
import applicationprototype.main.infrastructure.repository.IRepository;

public abstract class AbstractFinancialMoviment {
	
	protected IRepository<IEntity> entityRepo;
	protected IRepository<IValueObject> typeRepo;
	
	public AbstractFinancialMoviment(IRepository<IEntity> entityRepo, IRepository<IValueObject> typeRepo) {
		this.entityRepo = entityRepo;
		this.typeRepo = typeRepo;
	}
	
	protected void storeFinancialMoviment(IEntity entity) throws PersistenceException, IOException {
		entityRepo.store(entity);
	}

	public AbstractFinancialMovimentBuilder initializeFinancialMoviment(String registro, String type, Date date, double value) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, IOException {
		java.util.Properties properties = BuilderFactory.getProperties();
		return (AbstractFinancialMovimentBuilder) BuilderFactory.create(registro).newInstance(date,type,value);
	}
}