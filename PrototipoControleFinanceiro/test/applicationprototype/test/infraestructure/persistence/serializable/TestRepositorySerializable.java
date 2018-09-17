package applicationprototype.test.infraestructure.persistence.serializable;

import java.util.List;

import applicationprototype.main.domain.shared.IEntity;
import applicationprototype.main.infrastructure.persistence.AbstractRepository;
import applicationprototype.main.infrastructure.persistence.AbstractUnitOfWork;
import applicationprototype.main.infrastructure.persistence.IContext;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;

public class TestRepositorySerializable extends AbstractRepository {

	public TestRepositorySerializable(IContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	private String sampleData;
	


	public String getSampleData() {
		return sampleData;
	}

	public void setSampleData(String sampleData) {
		this.sampleData = sampleData;
	}



}
