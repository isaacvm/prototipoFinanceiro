package applicationprototype.main.domain.model.revenue;

import java.util.Date;

import applicationprototype.main.domain.shared.AbstractFinancialMovement;
import applicationprototype.main.domain.shared.IValueObject;

public class Revenue extends AbstractFinancialMovement{

	private IValueObject<RevenueTypeVO> type;

	public Revenue(Date date, IValueObject<RevenueTypeVO> type, Number value) {
		super(date,value);
		this.setType(type);
	}

	public IValueObject<RevenueTypeVO> getType() {
		return type;
	}

	public void setType(IValueObject<RevenueTypeVO> type) {
		this.type = type;
	}

	@Override
	public Object getById(Object key) {
		// TODO Auto-generated method stub
		return null;
	}
}
