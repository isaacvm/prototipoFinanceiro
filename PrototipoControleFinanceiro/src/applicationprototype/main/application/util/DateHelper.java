package applicationprototype.main.application.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public final class DateHelper {
	private static final DateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
	
	public static Date parseToDate(final String date) {
			try {
				return dateFormater.parse(date);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
	}
	
	public static String parseToString(final Date date) {
		if(date==null) throw new IllegalArgumentException("Não é possível converter data nula para texto");
		return dateFormater.format(date);
	}
}
