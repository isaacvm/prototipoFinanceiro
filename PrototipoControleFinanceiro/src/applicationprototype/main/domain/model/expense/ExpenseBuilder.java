package applicationprototype.main.domain.model.expense;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import applicationprototype.main.domain.shared.AbstractFinancialMovimentBuilder;
import applicationprototype.main.domain.shared.Entity;

public class ExpenseBuilder extends AbstractFinancialMovimentBuilder{

	
	private String classification;
	private String typeDescription;
	private Expense expense;

	public ExpenseBuilder(Date date,String type, Number value) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		super(date, type, value);
		this.typeDescription = type;
		this.expense=new Expense(date, value);
	}
	

	public ExpenseBuilder addNotes(String notes) {
		this.expense.setNotes(notes);
		return this;
	}
	
	public ExpenseBuilder addClassification(String classification) {
		this.classification=classification;
		return this;
	}
	
	public Entity<Expense> build() {
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

	public Number getValue() {
		return value;
	}
}
