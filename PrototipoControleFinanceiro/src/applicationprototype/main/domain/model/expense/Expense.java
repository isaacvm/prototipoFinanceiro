package applicationprototype.main.domain.model.expense;

import java.util.Date;

import applicationprototype.main.domain.shared.BaseFinancialMovement;
import applicationprototype.main.domain.shared.IValueObject;

public class Expense extends BaseFinancialMovement<Expense>{

	private IValueObject<ExpenseTypeVO> type;
	private IValueObject<ExpenseClassificationVO> classification;
	
	public Expense(final Date date,final IValueObject<ExpenseTypeVO> type,final IValueObject<ExpenseClassificationVO> classification,
			final double value) {
		super(date,value);
		this.type = type;
		this.classification = classification;
	}


	public Expense(final Date date, final double value) {
		super(date, value);
	}


	protected void setType(IValueObject<ExpenseTypeVO> type) {
		this.type = type;
	}


	protected void setClassification(IValueObject<ExpenseClassificationVO> classification) {
		this.classification = classification;
	}


	public IValueObject<ExpenseTypeVO> getType() {
		return type;
	}

	public IValueObject<ExpenseClassificationVO> getClassification() {
		return classification;
	}





}
