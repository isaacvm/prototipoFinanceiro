package applicationprototype.main.domain.model.revenue;

import java.util.List;

import applicationprototype.main.domain.shared.Entity;

public interface RevenueRepository {

	public void add(Entity entity);
	
	public void edit(Entity entity);
	
	public void remove(Entity entity);
	
	public List<Entity> getAll();	
}
