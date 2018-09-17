package applicationprototype.main.infrastructure.persistence;

import java.util.List;

import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;
import applicationprototype.main.infrastructure.persistence.serializable.SerializableContext;
import applicationprototype.main.infrastructure.repository.IRepository;

public interface IContext {
	
	public IRepository getRepository() throws PersistenceException;

	public boolean saveChanges();

	public SerializableContext set(IRepository repo);
	
}
