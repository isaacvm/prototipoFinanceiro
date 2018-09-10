package applicationprototype.test.application.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import applicationprototype.main.application.util.DateHelper;

public class DateHelperTest {
	
	private final String STRING_CONSTANT = "05/09/2018";
	private final Date DATE_CONSTANT = new GregorianCalendar(2018, Calendar.SEPTEMBER, 5).getTime();
	
	
	@Test
	public void validDateToString() {
		assertThat(DateHelper.parseToString(DATE_CONSTANT), equalTo(STRING_CONSTANT));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void invalidNullDateToString() {
		DateHelper.parseToString(null);
	}
	
	@Test
	public void validStringToDate() {
		assertTrue(DateHelper.parseToDate(STRING_CONSTANT).equals(DATE_CONSTANT));
	}
	
	@Test(expected=RuntimeException.class)
	public void invalidStringToDate() {
		DateHelper.parseToDate("teste");
	}
	
	@Test(expected=RuntimeException.class)
	public void invalidEmptyStringToDate() {
		DateHelper.parseToDate("");
	}
	
	@Test(expected=RuntimeException.class)
	public void invalidNullStringToDate() {
		DateHelper.parseToDate(null);
	}
	
	
}
