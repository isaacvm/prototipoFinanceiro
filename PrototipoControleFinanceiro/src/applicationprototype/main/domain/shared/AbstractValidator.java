package applicationprototype.main.domain.shared;

/*
 * MOTIVA��O
 * esta classe � respons�vel pela valida��o na cria��o das movimenta��es financeiras.
 * Toda classe que herda desta faz a valida��o espec�fica de cada entidade.
 */
public abstract class AbstractValidator{

	protected final AbstractFinancialMovimentBuilder builder;

	public abstract void validate();

	public AbstractValidator(AbstractFinancialMovimentBuilder builder) {
		this.builder = builder;
		commomValidate();
	}
	
	private final void commomValidate() {
		validateDate(this.builder.getDate());
		validateValue(this.builder.getValue());
	}

	private final <T> void validateValue(final T value) throws IllegalArgumentException {
		if (value == null) {
			throw new IllegalArgumentException("O valor monet�rio � nulo");
		} else if (((Double) value).doubleValue() <= 0) {
			throw new IllegalArgumentException("O valor monet�rio � menor ou igual a zero");
		}
	}

	private final <T> void validateDate(final T date) throws IllegalArgumentException {
		if (date == null) {
			throw new IllegalArgumentException("A data � nula");
		}
	}
}
