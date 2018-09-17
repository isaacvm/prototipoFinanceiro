package applicationprototype.main.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import applicationprototype.main.domain.model.expense.ExpenseClassificationVO;
import applicationprototype.main.infrastructure.persistence.AbstractRepository;
import applicationprototype.main.infrastructure.persistence.IContext;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;

public class ExpenseClassificationRepository<T> extends AbstractRepository<ExpenseClassificationVO>{
	
	static List<ExpenseClassificationVO> toStore = new ArrayList<>();
	
	public ExpenseClassificationRepository(IContext context) throws PersistenceException {
		super(context,toStore);
	}
}