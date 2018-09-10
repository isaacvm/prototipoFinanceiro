package applicationprototype.main.domain.model.revenue;

import applicationprototype.main.domain.shared.AbstractFinancialMovimentBuilder;
import applicationprototype.main.domain.shared.AbstractValidator;

public final class RevenueValidator extends AbstractValidator {

	public RevenueValidator(final AbstractFinancialMovimentBuilder builder) {
		super(builder);
	}
	
	@Override
	public void validate() {
		RevenueBuilder toVerify = (RevenueBuilder) this.builder;
		validateType(toVerify.getType());
	}

	private <T> void validateType(final T type) {
		if (type == null) {
			throw new IllegalArgumentException("O tipo de receita não pode ser nulo");
		} else if (((String) type).isEmpty()) 
			throw new IllegalArgumentException("O tipo de receita não pode ser vazio");
	}


	
}
