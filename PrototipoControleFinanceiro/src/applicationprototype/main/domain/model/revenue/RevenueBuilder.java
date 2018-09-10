package applicationprototype.main.domain.model.revenue;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;

import applicationprototype.main.domain.shared.AbstractFinancialMovement;
import applicationprototype.main.domain.shared.AbstractFinancialMovimentBuilder;
import applicationprototype.main.domain.shared.IValueObject;

public class RevenueBuilder extends AbstractFinancialMovimentBuilder{
	
	private Revenue revenue;
	
	protected AbstractFinancialMovement getEntity() {
		return revenue;
	}

	public RevenueBuilder(Date date, String type, Number value) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		super(date, type, value);
		new RevenueValidator(this);
		IValueObject<RevenueTypeVO> revenueType = new RevenueTypeVO(this.type);
		this.revenue = new Revenue(date, revenueType, value);
	}

	
	public String getNotes() {
		return notes;
	}

	protected void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getDate() {
		return date;
	}

	public Number getValue() {
		return value;
	}

	public RevenueBuilder addNotes(String notes) {
		revenue.setNotes(notes);
		return this;
	}
	
	protected String getType() {
		return type;
	}

	public Revenue build() {
		validator.validate();
		return this.revenue;
	}
}
