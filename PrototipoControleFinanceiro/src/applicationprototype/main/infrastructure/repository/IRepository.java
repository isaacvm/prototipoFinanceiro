package applicationprototype.main.infrastructure.repository;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import applicationprototype.main.domain.shared.IEntity;
import applicationprototype.main.domain.shared.IValueObject;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;
/*
 * S�o criados reposit�rios de todas as raizes de agregados,
 * agregados que podem ser usados por outras partes do sistema.
 * Esta � a interface base das raizes de agregados de movimenta��o financeira.
 */
public interface IRepository<T> extends Serializable{
	public void store(T instance) throws PersistenceException, IOException;
	public List getAll() throws PersistenceException;
}
