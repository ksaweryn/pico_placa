/**
 * Class DateTime.java created 13 Mar 2018
 * Copyright javier All rights reserved
 */
package ec.javier.pp.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * @author javier
 *
 */
public class DateTime {

	String date;
	String time;

	public DateTime() {

	}

	public DateTime(String date, String time) {
		this.date = date;
		this.time = time;
	}

	public static LocalDate returnDate(String date) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
			return LocalDate.parse(date, formatter);
		} catch (DateTimeParseException e) {
			System.out.println("Please insert date in the next format dd-MM-yyyy");
			System.out.println("Please restart");
			System.exit(0);
		}
		return null;
		
	}

	public static LocalTime returnTime(String time) {
		return LocalTime.parse(time);
	}

	public static Boolean hasPicoPlaca(int day, LocalDate date) {
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		if (dayOfWeek.getValue() >= 1 && dayOfWeek.getValue() <= 5) {
			return isVehicleWithRestriction(dayOfWeek, day);
		}

		return Boolean.FALSE;
	}

	public static Boolean isTimeInRestrictionPeriod(LocalTime time) {
		String t = time.toString();
		if (t.compareTo("07:00") >= 0 && t.compareTo("09:30") <= 0) {
			return Boolean.TRUE;
		} else if (t.compareTo("16:00") >= 0 && t.compareTo("19:30") <= 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	private static Boolean isVehicleWithRestriction(DayOfWeek dayOfWeek, int day) {
		return dayOfWeek.getValue() == day;

	}

}
