package applicationprototype.main.domain.shared;

import java.io.Serializable;

public interface IValueObject<T> extends Serializable {

	boolean isTheSameOf(T other);
}
