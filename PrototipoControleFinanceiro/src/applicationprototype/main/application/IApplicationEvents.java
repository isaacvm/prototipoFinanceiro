package applicationprototype.main.application;

import applicationprototype.main.domain.shared.Entity;

public interface IApplicationEvents {
	
	void registryNewEntity(Entity entity);
	
	void modifyEntity(Entity entity);
	
	void removeEntity(Entity entity);
}
