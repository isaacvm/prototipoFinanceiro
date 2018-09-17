package applicationprototype.main.domain.shared;

import java.io.Serializable;

/*
 * Tudo que implementa esta classe possui algum tipo de identidade, 
 * logo, � necess�rio a possiblidade de identifica-lo unicamente no sistema.
 * As classes que implementam esta interface tiveram este crit�rio para a cria��o.
 */
public interface IEntity<T> extends Serializable{
	
	T getById(Number key);
	
}
