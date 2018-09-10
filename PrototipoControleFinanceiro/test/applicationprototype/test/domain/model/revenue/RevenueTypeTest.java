package applicationprototype.test.domain.model.revenue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import applicationprototype.main.domain.model.expense.ExpenseClassificationVO;
import applicationprototype.main.domain.model.expense.ExpenseTypeVO;
import applicationprototype.main.domain.model.revenue.RevenueTypeVO;
import applicationprototype.main.domain.shared.IValueObject;
import applicationprototype.test.domain.model.expense.ExpenseTypeTest;

public class RevenueTypeTest {
	
	private String revenueType;

	private final RevenueTypeVO REVENUE_TYPE = new RevenueTypeVO("Consultoria");

	@Test
	public void NullArgument() {
		assertFalse(REVENUE_TYPE.equals(null));
		assertFalse(REVENUE_TYPE.isTheSameOf(null));
	}

	@Test
	public void differentObject() {
		assertFalse(REVENUE_TYPE.equals(RevenueTypeTest.class));
	}
	
	@Test
	public void differentObjectArguments() {
		final IValueObject<RevenueTypeVO> TYPE2 = new RevenueTypeVO("Salário");
		assertFalse(REVENUE_TYPE.equals(TYPE2));
		assertFalse(REVENUE_TYPE.isTheSameOf((RevenueTypeVO)TYPE2));
	}

	@Test
	public void isSameObject() {
		assertTrue(REVENUE_TYPE.equals(REVENUE_TYPE));
		assertTrue(REVENUE_TYPE.isTheSameOf(REVENUE_TYPE));
	}

}
