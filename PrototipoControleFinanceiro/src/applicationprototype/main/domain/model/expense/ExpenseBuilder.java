package applicationprototype.main.domain.model.expense;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import applicationprototype.main.domain.shared.AbstractFinancialMovimentBuilder;
import applicationprototype.main.domain.shared.IEntity;

public class ExpenseBuilder extends AbstractFinancialMovimentBuilder{

	
	private String classification;
	private String typeDescription;
	private Expense expense;

	public ExpenseBuilder(final Date date,final String type,final double value) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		super(date, type, value);
		this.typeDescription = type;
		this.expense=new Expense(date, value);
	}
	

	public ExpenseBuilder addNotes(final String notes) {
		this.expense.setNotes(notes);
		return this;
	}
	
	public ExpenseBuilder addClassification(final String classification) {
		this.classification=classification;
		return this;
	}
	
	public Expense build() {
		this.expense.setClassification(new ExpenseClassificationVO(classification));
		this.expense.setType(new ExpenseTypeVO(this.expense.getClassification(), this.type));
		this.validator.validate();
		return this.expense;
	}
	
	String getClassification() {
		return classification;
	}

	protected String getType() {
		return typeDescription;
	}

	public Date getDate() {
		return date;
	}

	public double getValue() {
		return value;
	}
}
