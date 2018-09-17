package applicationprototype.main.application.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;

import applicationprototype.main.application.AbstractFinancialMoviment;
import applicationprototype.main.domain.model.expense.ExpenseBuilder;
import applicationprototype.main.domain.shared.IEntity;
import applicationprototype.main.domain.shared.IValueObject;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;
import applicationprototype.main.infrastructure.repository.IRepository;

public class ExpenseMovimentImpl extends AbstractFinancialMoviment {
	
	private IRepository<IValueObject>classificationRepo;
	

	public ExpenseMovimentImpl(IRepository<IEntity> entityRepo, IRepository<IValueObject> typeRepo,IRepository<IValueObject> classifRepo) {
		super(entityRepo, typeRepo);
		this.classificationRepo=classifRepo;
	}

	public void createMoviment(String registro, String type, String classification, Date date, double value,
			String notes) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, IOException, PersistenceException {
		ExpenseBuilder builder = (ExpenseBuilder) super.initializeFinancialMoviment(registro, type, date, value);
		createExpense(builder, classification, notes);
	}

	private void createExpense(ExpenseBuilder builder, String classification,
			String notes) throws PersistenceException, IOException {
		builder.addClassification(classification);
		if(notes!=null&&!notes.isEmpty()) {
			builder.addNotes(notes);
		}
		storeFinancialMoviment(builder.build());
	}
}
