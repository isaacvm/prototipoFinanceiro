package applicationprototype.main.domain.shared;

import java.io.Serializable;

/*
 * Todas as classes que implementam esta interface têm um estado hipotético de algum
 * tipo de movimentação financeira que está associado a um registro de operação financeira.
 * Tudo que implementou esta interface foi definido pensando nesta linha
 */
public interface IValueObject<T> extends Serializable {

	boolean isTheSameOf(T other);
}
