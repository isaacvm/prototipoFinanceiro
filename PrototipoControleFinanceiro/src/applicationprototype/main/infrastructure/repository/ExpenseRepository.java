package applicationprototype.main.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import applicationprototype.main.domain.model.expense.Expense;
import applicationprototype.main.infrastructure.persistence.AbstractRepository;
import applicationprototype.main.infrastructure.persistence.IContext;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;

public class ExpenseRepository extends AbstractRepository<Expense> {

	static List<Expense> toStore = new ArrayList<>();
	
	public ExpenseRepository(IContext context) throws PersistenceException {
		super(context,toStore);
	}
}
