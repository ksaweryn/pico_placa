/**
 * Class DateTime.java created 13 Mar 2018
 * Copyright javier All rights reserved
 */
package ec.javier.pp.date;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author javier
 *
 */
public class DateTime {
	
	String date;
	String time;

	public DateTime(String date, String time) {
		this.date = date;
		this.time = time;
	}
	
	public LocalDate returnDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH); 
		return LocalDate.parse(date, formatter);
	}
	
	public LocalTime returnTime(String time) {
		
		return LocalTime.parse(time);
	}

}
