package applicationprototype.main.domain.shared;

import java.util.Date;

public abstract class AbstractFinancialMovement<T> implements Entity<T>{


	private Date date;
	private Number value;
	private String notes;
	
	public AbstractFinancialMovement(Date date, Number value) {
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

	public Number getValue() {
		return value;
	}
	
	
}
