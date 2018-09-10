package applicationprototype.main.infrastructure.persistence.serializable;

import java.util.List;

import applicationprototype.main.domain.model.expense.ExpenseRepository;
import applicationprototype.main.domain.shared.Entity;

public class ExpenseRepositorySerializable extends AbstractRepositorySerializable implements ExpenseRepository{
	
	public ExpenseRepositorySerializable() {
		super();
	}

	@Override
	public void add(Entity entity) {
		
	}

	@Override
	public void edit(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Entity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(List<Entity> collection) {
		if(collection!=null) {
			
		}
	}

	@Override
	public List<Entity> read() {
		// TODO Auto-generated method stub
		return null;
	}

}
