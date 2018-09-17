package applicationprototype.main.infrastructure.persistence.serializable;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import applicationprototype.main.domain.model.expense.Expense;
import applicationprototype.main.domain.model.revenue.Revenue;
import applicationprototype.main.domain.model.revenue.RevenueTypeVO;
import applicationprototype.main.domain.shared.CoreFactory;
import applicationprototype.main.infrastructure.persistence.AbstractUnitOfWork;
import applicationprototype.main.infrastructure.persistence.IContext;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;
import applicationprototype.main.infrastructure.repository.ExpenseClassificationRepository;
import applicationprototype.main.infrastructure.repository.ExpenseRepository;
import applicationprototype.main.infrastructure.repository.ExpenseTypeRepository;
import applicationprototype.main.infrastructure.repository.IRepository;
import applicationprototype.main.infrastructure.repository.RevenueRepository;

public class UnitOfWork extends AbstractUnitOfWork {
	protected ExpenseRepository exrep;
	protected RevenueRepository revrep;
	protected RevenueTypeVO revtype;
	protected ExpenseTypeRepository exty;
	protected ExpenseClassificationRepository excla;
	
	public UnitOfWork(IContext context) {
		super(context);
	}

	@Override
	public void save() throws PersistenceException {
		context.saveChanges();
	}

	@Override
	public List load() throws PersistenceException {
		IRepository r = context.getRepository();
		if(r instanceof ExpenseRepository)
			exrep = (ExpenseRepository) r;
		return 
	}
	
/*	public IRepository<Revenue> revenues() throws IOException{
		if(this.revenues==null) {
			try {
				this.revenues=(IRepository<Revenue>) CoreFactory.create("revenue.repository").newInstance(this.context);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		}
		return this.revenues;
		}
		
	public IRepository<Expense> expenses() throws IOException{
		if(this.revenues==null) {
			try {
				this.expenses=(IRepository<Expense>) CoreFactory.create("expense.repository").newInstance(this.context);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		}
		return this.expenses;
		}*/
}