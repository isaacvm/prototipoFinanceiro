package applicationprototype.test.domain.model.expense;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import applicationprototype.main.domain.model.expense.ExpenseClassificationVO;

public class ExpenseClassificationTest {

	private final ExpenseClassificationVO EXPENSE_CLASSIFICATION = new ExpenseClassificationVO("Fixa");
	
	@Test
	public void NullArgument() {
		assertFalse(EXPENSE_CLASSIFICATION.equals(null));
		assertFalse(EXPENSE_CLASSIFICATION.isTheSameOf(null));
	}

	@Test
	public void differentObject() {
		assertFalse(EXPENSE_CLASSIFICATION.equals(ExpenseTypeTest.class));
	}
	
	@Test
	public void differentObjectArguments() {
		assertFalse(EXPENSE_CLASSIFICATION.equals(new ExpenseClassificationVO("Extra")));
		assertFalse(EXPENSE_CLASSIFICATION.isTheSameOf(new ExpenseClassificationVO("Extra")));
	}

	@Test
	public void isSameObject() {
		assertTrue(EXPENSE_CLASSIFICATION.equals(EXPENSE_CLASSIFICATION));
		assertTrue(EXPENSE_CLASSIFICATION.equals(EXPENSE_CLASSIFICATION));
	}
}
