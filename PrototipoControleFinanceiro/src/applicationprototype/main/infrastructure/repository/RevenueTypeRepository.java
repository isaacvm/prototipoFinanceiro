package applicationprototype.main.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import applicationprototype.main.domain.model.expense.Expense;
import applicationprototype.main.domain.model.revenue.RevenueTypeVO;
import applicationprototype.main.infrastructure.persistence.AbstractRepository;
import applicationprototype.main.infrastructure.persistence.IContext;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;

public class RevenueTypeRepository extends AbstractRepository<RevenueTypeVO>{

	static List<RevenueTypeVO> toStore = new ArrayList<>();
	
	public RevenueTypeRepository(IContext context) throws PersistenceException {
		super(context,toStore);
	}
}
