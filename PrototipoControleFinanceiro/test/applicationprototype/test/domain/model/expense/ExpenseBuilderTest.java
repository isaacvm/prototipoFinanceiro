package applicationprototype.test.domain.model.expense;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import applicationprototype.main.application.util.DateHelper;
import applicationprototype.main.domain.model.expense.Expense;
import applicationprototype.main.domain.model.expense.ExpenseBuilder;
import applicationprototype.main.domain.model.expense.ExpenseClassificationVO;
import applicationprototype.main.domain.model.expense.ExpenseTypeVO;

public class ExpenseBuilderTest {

	private Date date;
	private BigDecimal value;
	private String type;
	private String classification;

	@Before
	public void setUp() {
		this.date = DateHelper.parseToDate("05/09/2018");
		this.value = new BigDecimal(1500.25);
		this.classification = "Fixa";
		this.type = "Aluguel";
	}

	@Test
	public void buildExpenseWithoutNotes()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		Expense e1 = (Expense) new ExpenseBuilder(date, type, value).addClassification(classification).build();
		ExpenseClassificationVO expenseClassification = new ExpenseClassificationVO(classification);
		assertEquals(date, e1.getDate());
		assertTrue(expenseClassification.equals(e1.getClassification()));
		assertTrue(new ExpenseTypeVO(expenseClassification, type).equals(e1.getType()));
		assertEquals(value.doubleValue(), e1.getValue().doubleValue(), 0.00001);
	}

	@Test
	public void buildExpenseWithNotes() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		String notes = "Teste Unitario de despensa";
		Expense e1 = (Expense) new ExpenseBuilder(date, type, value).addClassification(classification).addNotes(notes)
				.build();
		ExpenseClassificationVO expenseClassification = new ExpenseClassificationVO(classification);
		assertEquals(date, e1.getDate());
		assertEquals(expenseClassification.hashCode(), e1.getClassification().hashCode());
		assertEquals(new ExpenseTypeVO(expenseClassification, type).hashCode(), e1.getType().hashCode());
		assertEquals(value.doubleValue(), e1.getValue().doubleValue(), 0.00001);
		assertEquals(notes, e1.getNotes());
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestBuildWithInvalidNullClassification()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		new ExpenseBuilder(date, type, value).addClassification(null).build();
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestBuildWithInvalidEmptyClassification()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		new ExpenseBuilder(date, type, value).addClassification("").build();
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestBuildWithInvalidNullType()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		new ExpenseBuilder(date, null, value).addClassification(classification).build();
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestBuildWithInvalidEmptyType()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		new ExpenseBuilder(date, "", value).addClassification(classification).build();
	}
}
