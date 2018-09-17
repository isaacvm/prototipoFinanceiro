package applicationprototype.main.infrastructure.persistence.exception;

public class PersistenceException extends Exception {
	
	public PersistenceException(Exception e) {
		e.printStackTrace();
	}
}
