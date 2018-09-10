package applicationprototype.test.domain.model.expense;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import applicationprototype.main.domain.model.expense.ExpenseClassificationVO;
import applicationprototype.main.domain.model.expense.ExpenseTypeVO;
import applicationprototype.main.domain.shared.IValueObject;

public class ExpenseTypeTest {

	private final ExpenseClassificationVO EXPENSE_CLASSIFICATION=new ExpenseClassificationVO("Fixa");
	private final ExpenseTypeVO EXPENSE_TYPE = new ExpenseTypeVO(EXPENSE_CLASSIFICATION, "Aluguél");

	@Test
	public void NullArgument() {
		assertFalse(EXPENSE_TYPE.equals(null));
		assertFalse(EXPENSE_TYPE.isTheSameOf(null));
	}

	@Test
	public void differentObject() {
		assertFalse(EXPENSE_TYPE.equals(ExpenseTypeTest.class));
	}
	
	@Test
	public void differentObjectArguments() {
		final IValueObject<ExpenseTypeVO> TYPE2 = new ExpenseTypeVO(EXPENSE_CLASSIFICATION, "Gasolina");
		final IValueObject<ExpenseTypeVO> TYPE3 = new ExpenseTypeVO(new ExpenseClassificationVO("Variável"),"gasolina");
		assertFalse(EXPENSE_TYPE.equals(TYPE2));
		assertFalse(EXPENSE_TYPE.isTheSameOf((ExpenseTypeVO)TYPE2));
		assertFalse(EXPENSE_TYPE.isTheSameOf((ExpenseTypeVO)TYPE3));
	}

	@Test
	public void isSameObject() {
		assertTrue(EXPENSE_TYPE.equals(EXPENSE_TYPE));
		assertTrue(EXPENSE_TYPE.isTheSameOf(EXPENSE_TYPE));
	}
}
