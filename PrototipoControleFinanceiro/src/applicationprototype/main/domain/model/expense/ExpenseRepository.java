package applicationprototype.main.domain.model.expense;

import java.util.List;

import applicationprototype.main.domain.shared.Entity;

public interface ExpenseRepository {
	
	public void add(Entity entity);
	
	public void edit(Entity entity);
	
	public void remove(Entity entity);
	
	public List<Entity> getAll();	
}
