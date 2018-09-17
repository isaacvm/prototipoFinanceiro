package applicationprototype.main.infrastructure.persistence;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import applicationprototype.main.domain.model.revenue.RevenueTypeVO;
import applicationprototype.main.domain.shared.CoreFactory;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;
import applicationprototype.main.infrastructure.repository.ExpenseClassificationRepository;
import applicationprototype.main.infrastructure.repository.ExpenseRepository;
import applicationprototype.main.infrastructure.repository.ExpenseTypeRepository;
import applicationprototype.main.infrastructure.repository.IRepository;
import applicationprototype.main.infrastructure.repository.RevenueRepository;

/*
 * Camada de infraestrutura para persist�ncia de dados. A decis�o de colocar em um sub-pacote
 * dentro de persist�ncia � porque podemos ter v�rias tecnologias de persist�ncia. Tudo que
 * � raiz de um agregado � persistido, tamb�m ser�o persistidos os Objetos de Valor, de forma que eles possam ser
 * recuperados em uma implementa��o futura para corrigir, por exemplo, um nome escrito errado.
 */
public abstract class AbstractUnitOfWork<T> implements Serializable {

	protected IContext context;

	
	// evitar instancia��o direta
	protected AbstractUnitOfWork(IContext context) {
		this.context = context;
	}

	public abstract void save() throws PersistenceException;

	public abstract List load() throws PersistenceException;

	public IContext set(IRepository repo) throws PersistenceException {
		/*String base = repo.getClass().getSimpleName();
		if(base.toLowerCase().endsWith("repository")) {
			base = base.substring(0, base.length()-10);
		}
		base += ".repository";
		try {
			Constructor constructor = CoreFactory.create(base);
			if(constructor.getClass().getSimpleName() != repo.getClass().getSimpleName()) {
			this.repository = (List) constructor.newInstance(this.context);*/
			this.context.set(repo);
		/*	}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | IOException
				| InvocationTargetException e) {
			throw new PersistenceException(e);
		}*/
		return this.context;
	}

}