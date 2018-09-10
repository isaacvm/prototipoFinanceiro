package applicationprototype.test.infraestructure.persistence.serializable;

import org.junit.Test;

import applicationprototype.main.infrastructure.persistence.serializable.ExpenseRepositorySerializable;

public class ArchievePersistenceHandling {

	@Test
	public void createFileWithSuccess() {
		new ExpenseRepositorySerializable();
	}
	
}
