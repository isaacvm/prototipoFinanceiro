package applicationprototype.main.infrastructure.persistence;

import java.io.IOException;
import java.util.List;

import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;
import applicationprototype.main.infrastructure.persistence.serializable.UnitOfWork;
import applicationprototype.main.infrastructure.repository.IRepository;

public abstract class AbstractRepository<T> implements IRepository<T>{
	
	protected static AbstractUnitOfWork unitOfWork;
	protected List<T> collection;
	
	public AbstractRepository(IContext context,List<T> collection) throws PersistenceException {
		this.unitOfWork = new UnitOfWork(context);
		this.collection = collection;
	}
	
	@Override
	public void store(T instance) throws PersistenceException, IOException {
		this.collection.add(instance);
		unitOfWork.set(this);
		unitOfWork.save();
	}
	
	public List getAll() throws PersistenceException {
		unitOfWork.set(this);
		return unitOfWork.load();
	}
	
	
}
