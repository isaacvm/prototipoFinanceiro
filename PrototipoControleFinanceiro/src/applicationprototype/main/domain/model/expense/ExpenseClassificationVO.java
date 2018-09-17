package applicationprototype.main.domain.model.expense;

import applicationprototype.main.domain.shared.IValueObject;

public class ExpenseClassificationVO implements IValueObject<ExpenseClassificationVO>{
	
	private static final long serialVersionUID = 1L;
	private String description;

	@SuppressWarnings("unused")
	private ExpenseClassificationVO() {
		
	}
	
	public ExpenseClassificationVO(final String description) {
		super();
		this.description = description;
	}

	@Override
	public boolean equals(final Object other) {
		if(other==null ||other.getClass()!=this.getClass()) return false;
		return isTheSameOf((ExpenseClassificationVO)other);
	}
	
	@Override
	public int hashCode() {
		return this.description.hashCode();
	}

	@Override
	public boolean isTheSameOf(final ExpenseClassificationVO other) {
		if(other==null) return false;
		return this.hashCode()==other.hashCode();	}
}
