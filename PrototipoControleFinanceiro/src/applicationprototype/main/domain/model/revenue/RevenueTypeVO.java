package applicationprototype.main.domain.model.revenue;

import applicationprototype.main.domain.shared.IValueObject;

public class RevenueTypeVO implements IValueObject<RevenueTypeVO> {
	
	private String description;

	public RevenueTypeVO(String type) {
		this.description=type;
	}

	@Override
	public boolean equals(Object other) {
		if(other==null ||other.getClass()!=this.getClass()) return false;
		return isTheSameOf((RevenueTypeVO)other);
	}
	
	@Override
	public int hashCode() {
		return description.hashCode();
	}
	
	@Override
	public boolean isTheSameOf(RevenueTypeVO other) {
		if(other==null) return false;
		return this.hashCode()==other.hashCode();
	}

}
