package applicationprototype.main.domain.model.expense;

import applicationprototype.main.domain.shared.AbstractFinancialMovimentBuilder;
import applicationprototype.main.domain.shared.AbstractValidator;

public final class ExpenseValidator extends AbstractValidator {

	public ExpenseValidator(final AbstractFinancialMovimentBuilder builder) {
		super(builder);
	}

	@Override
	public void validate() {
		ExpenseBuilder toVerify = (ExpenseBuilder) this.builder;
		validateClassification(toVerify.getClassification());
		validateType(toVerify.getType());
	}

	private <T> void validateType(final T type) {
		if (type == null) {
			throw new IllegalArgumentException("O tipo não pode ser nula");
		} else if (((String) type).isEmpty())
			throw new IllegalArgumentException("O tipo não pode ser vazia");		
	}

	private <T> void validateClassification(final T classification) {
		if (classification == null) {
			throw new IllegalArgumentException("A classificação não pode ser nula");
		} else if (((String) classification).isEmpty())
			throw new IllegalArgumentException("A classificação não pode ser vazia");
	}

}
