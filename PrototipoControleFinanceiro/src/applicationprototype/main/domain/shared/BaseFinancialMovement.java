package applicationprototype.main.domain.shared;

import java.util.Date;

import applicationprototype.main.domain.model.expense.Expense;

/*
 * MOTIVAÇÃO
 * Todos que herdam desta classe são um tipo de movimentação financeira.
 * Movimentação financeira pode ser receita, despesa, entre outros (e.g. investimentos).
 * 
 */
public abstract class BaseFinancialMovement<T> implements IEntity{

	private int id;
	private Date date;
	private double value;
	private String notes;
	
	public BaseFinancialMovement(final Date date,final double value) {
		this.value=value;
		this.date = date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getDate() {
		return date;
	}

	public double getValue() {
		return value;
	}

	@Override
		public Object getById(Number key) {
			return this.id;
		}
	
	
}
