package applicationprototype.main.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import applicationprototype.main.domain.model.expense.Expense;
import applicationprototype.main.domain.model.revenue.Revenue;
import applicationprototype.main.infrastructure.persistence.AbstractRepository;
import applicationprototype.main.infrastructure.persistence.IContext;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;

public class RevenueRepository extends AbstractRepository<Revenue>{
		
	static List<Revenue> toStore = new ArrayList<>();
	
	public RevenueRepository(IContext context) throws PersistenceException {
		super(context,toStore);
	}
}
