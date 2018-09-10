package applicationprototype.main.domain.shared;

import java.io.Serializable;

public interface Entity<T> extends Serializable{
	
	T getById(T key);
	
}
