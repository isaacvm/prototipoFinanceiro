package applicationprototype.main.application.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;

import applicationprototype.main.application.AbstractFinancialMoviment;
import applicationprototype.main.domain.model.revenue.RevenueBuilder;
import applicationprototype.main.domain.shared.IEntity;
import applicationprototype.main.domain.shared.IValueObject;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;
import applicationprototype.main.infrastructure.repository.IRepository;

public class RevenueMovimentImpl extends AbstractFinancialMoviment {

	public RevenueMovimentImpl(IRepository<IEntity> entityRepo, IRepository<IValueObject> typeRepo) {
		super(entityRepo, typeRepo);
	}

	private void createRevenue(RevenueBuilder newBuilder,  String notes) throws PersistenceException, IOException {
		if(notes!=null&&!notes.isEmpty()) {
			newBuilder.addNotes(notes);
		}
		storeFinancialMoviment(newBuilder.build());
	}
	
	public void createMoviment(String registro, String type, Date date, double value,
			String notes) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, IOException, PersistenceException {
		RevenueBuilder builder =  (RevenueBuilder) super.initializeFinancialMoviment(registro,type,date,value);
		createRevenue(builder,notes);
		}

}
