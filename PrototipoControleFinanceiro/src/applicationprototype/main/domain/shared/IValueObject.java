package applicationprototype.main.domain.shared;

import java.io.Serializable;

/*
 * Todas as classes que implementam esta interface t�m um estado hipot�tico de algum
 * tipo de movimenta��o financeira que est� associado a um registro de opera��o financeira.
 * Tudo que implementou esta interface foi definido pensando nesta linha
 */
public interface IValueObject<T> extends Serializable {

	boolean isTheSameOf(T other);
}
