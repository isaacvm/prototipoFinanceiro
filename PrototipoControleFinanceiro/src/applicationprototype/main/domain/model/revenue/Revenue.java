package applicationprototype.main.domain.model.revenue;

import java.util.Date;

import applicationprototype.main.domain.shared.BaseFinancialMovement;
import applicationprototype.main.domain.shared.IValueObject;

public class Revenue extends BaseFinancialMovement<Revenue>{

	private IValueObject<RevenueTypeVO> type;

	public Revenue(Date date, IValueObject<RevenueTypeVO> type, double value) {
		super(date,value);
		this.setType(type);
	}

	public IValueObject<RevenueTypeVO> getType() {
		return type;
	}

	public void setType(IValueObject<RevenueTypeVO> type) {
		this.type = type;
	}

}
