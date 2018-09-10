package applicationprototype.main.domain.model.expense;

import java.util.Date;

import applicationprototype.main.domain.shared.AbstractFinancialMovement;
import applicationprototype.main.domain.shared.IValueObject;

public class Expense extends AbstractFinancialMovement{

	private IValueObject<ExpenseTypeVO> type;
	private IValueObject<ExpenseClassificationVO> classification;
	
	public Expense(Date date, IValueObject<ExpenseTypeVO> type, IValueObject<ExpenseClassificationVO> classification,
			Number value) {
		super(date,value);
		this.type = type;
		this.classification = classification;
	}


	public Expense(Date date, Number value) {
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

	@Override
	public Expense getById(Object key) {
		return null;
	}



}
