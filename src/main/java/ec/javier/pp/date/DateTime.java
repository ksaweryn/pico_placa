/**
 * Class DateTime.java created 13 Mar 2018
 */
package ec.javier.pp.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * 
 * Handles the Date and Time information. Provides methods to process date
 * related data.
 * 
 * @author Javier Borja
 *
 */
public class DateTime {

	/**
	 * Transforms date input into LocalDate. It validates the date pattern. It exits
	 * the program if date input is in wrong pattern.
	 * 
	 * @param date
	 *            String
	 * @return LocalDate
	 */
	public static LocalDate returnDate(String date) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
			return LocalDate.parse(date, formatter);
		} catch (DateTimeParseException e) {
			System.out.println("Please insert date in the next pattern dd-MM-yyyy");
			System.out.println("Please restart");
			System.exit(0);
		}
		return null;
	}

	/**
	 * Transforms time input into LocalTime. It validates the time pattern. It exits
	 * the program if time input is in wrong pattern.
	 * 
	 * @param time
	 *            String
	 * @return LocalTime
	 */
	public static LocalTime returnTime(String time) {
		try {
			return LocalTime.parse(time);
		} catch (DateTimeParseException e) {
			System.out.println("Please insert the time in the next pattern hh:mm\nE.g. 16:34");
			System.out.println("Please restart");
			System.exit(0);
		}
		return null;
	}

	/**
	 * Verifies if the day of the date has 'Pico y Placa' restriction related with
	 * the vehicle license last digit
	 * 
	 * @param day
	 *            int vehicle day of restriction
	 * @param date
	 *            LocalDate
	 * @return Boolean the vehicle license has 'Pico y Placa' restriction
	 */
	public static Boolean hasPicoPlaca(int day, LocalDate date) {
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		if (dayOfWeek.getValue() >= 1 && dayOfWeek.getValue() <= 5) {
			return isVehicleWithRestriction(dayOfWeek, day);
		}
		return Boolean.FALSE;
	}

	/**
	 * Verifies if the vehicle with Pico y Placa restriction is in the hours of
	 * restriction
	 * 
	 * @param time
	 *            LocalTime
	 * @return Boolean the restriction is in progress at the time
	 */
	public static Boolean isTimeInRestrictionPeriod(LocalTime time) {
		String t = time.toString();
		if (t.compareTo("07:00") >= 0 && t.compareTo("09:30") <= 0) {
			return Boolean.TRUE;
		} else if (t.compareTo("16:00") >= 0 && t.compareTo("19:30") <= 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * Verifies if the day of the date is the restriction day of the vehicle
	 * 
	 * @param dayOfWeek
	 *            DayOfWeek from the date
	 * @param day
	 *            int from the vehicle license
	 * @return Boolean weather the vehicle has a restriction that day of the week
	 */
	private static Boolean isVehicleWithRestriction(DayOfWeek dayOfWeek, int day) {
		return dayOfWeek.getValue() == day;

	}

}
