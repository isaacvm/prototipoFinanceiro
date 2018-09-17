package applicationprototype.main.domain.model.expense;

import applicationprototype.main.domain.shared.IValueObject;

public class ExpenseTypeVO implements IValueObject<ExpenseTypeVO>{

	private IValueObject<ExpenseClassificationVO> classification;
	private String description;
		
	@SuppressWarnings("unused")
	private ExpenseTypeVO() {
		
	}
	
	public ExpenseTypeVO(final IValueObject<ExpenseClassificationVO> classification,final String description) {
		super();
		this.classification = classification;
		this.description = description;
	}

	@Override
	public boolean equals(final Object other) {
		if(other==null ||other.getClass()!=this.getClass()) return false;
		return isTheSameOf((ExpenseTypeVO)other);
	}
	
	@Override
	public int hashCode() {
		return (description+String.valueOf(classification.hashCode())).hashCode();
	}
	
	@Override
	public boolean isTheSameOf(final ExpenseTypeVO other) {
		if(other==null) return false;
		return this.hashCode()==other.hashCode() && this.classification.isTheSameOf((ExpenseClassificationVO) other.getClassification());
	}

	public IValueObject<ExpenseClassificationVO> getClassification() {
		return classification;
	}
}
