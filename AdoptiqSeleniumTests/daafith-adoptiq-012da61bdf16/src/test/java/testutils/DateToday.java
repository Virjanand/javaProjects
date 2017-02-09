package testutils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import web.browsersession.Language;
import web.browsersession.TestConfiguration;

public class DateToday {
	
	private final static SimpleDateFormat NL  = new SimpleDateFormat("dd-MM-yyyy");
	private final static SimpleDateFormat EN  = new SimpleDateFormat("MM-dd-yyyy");

	private final Calendar calendar;
	
	public DateToday() {
		calendar = Calendar.getInstance();
		calendar.setTime(calendar.getTime());
	}
	
	@Override
	public String toString() {
		if (Language.EN.equals(TestConfiguration.getLanguage())) {
			return EN.format(calendar.getTime());
		} 
		return NL.format(calendar.getTime());
	}
	
	public DateToday minusDays(int days) {
		final int negativeValue  = -1 * days;
		calendar.add(Calendar.DATE, negativeValue);
		return this;
	}

	public DateToday plusDays(int days) {
		calendar.add(Calendar.DATE, days);
		return this;
	}
	
	public DateToday minusWeeks(int weeks) {
		final int negativeValue  = -1 * weeks;
		calendar.add(Calendar.WEEK_OF_YEAR, negativeValue);
		return this;
	}
	
	public DateToday plusWeeks(int weeks) {
		calendar.add(Calendar.WEEK_OF_YEAR, weeks);
		return this;
	}
	
	public DateToday minusMonths(int months) {
		final int negativeValue  = -1 * months;
		calendar.add(Calendar.MONTH, negativeValue);
		return this;
	}
	
	public DateToday plusMonths(int months) {
		calendar.add(Calendar.MONTH, months);
		return this;
	}

}
