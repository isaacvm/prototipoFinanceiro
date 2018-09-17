package applicationprototype.main.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import applicationprototype.main.domain.model.expense.Expense;
import applicationprototype.main.domain.model.expense.ExpenseTypeVO;
import applicationprototype.main.infrastructure.persistence.AbstractRepository;
import applicationprototype.main.infrastructure.persistence.IContext;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;

public class ExpenseTypeRepository extends AbstractRepository<ExpenseTypeVO>{

	static List<ExpenseTypeVO> toStore = new ArrayList<>();
	
	public ExpenseTypeRepository(IContext context) throws PersistenceException {
		super(context,toStore);
	}
	
}
