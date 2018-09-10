package applicationprototype.main.domain.shared;

import applicationprototype.main.domain.model.revenue.RevenueBuilder;

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
			throw new IllegalArgumentException("O valor monetário é nulo");
		} else if (((Number) value).doubleValue() <= 0) {
			throw new IllegalArgumentException("O valor monetário é menor ou igual a zero");
		}
	}

	private final <T> void validateDate(final T date) throws IllegalArgumentException {
		if (date == null) {
			throw new IllegalArgumentException("A data é nula");
		}
	}
}
