package applicationprototype.main.domain.shared;

import java.io.Serializable;

/*
 * Tudo que implementa esta classe possui algum tipo de identidade, 
 * logo, é necessário a possiblidade de identifica-lo unicamente no sistema.
 * As classes que implementam esta interface tiveram este critério para a criação.
 */
public interface IEntity<T> extends Serializable{
	
	T getById(Number key);
	
}
