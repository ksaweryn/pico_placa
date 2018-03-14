/**
 * Class DateTimeTest.java created 13 Mar 2018
 * Copyright javier All rights reserved
 */
package ec.javier.pp.test.date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import ec.javier.pp.date.DateTime;

/**
 * @author javier
 *
 */
public class DateTimeTest {

	private static DateTime dateTime;
	private static String date;
	private static String time;

	@Before
	public void initialize() {
		date = "13-03-2018";
		time = "11:23";
		dateTime = new DateTime(date, time);
	}

	@Test
	public void shouldReturnDate() {
		assertThat(dateTime.returnDate("13-03-2018"), is(LocalDate.class));
		LocalDate localDate = dateTime.returnDate("13-03-2018");
		System.out.println(localDate.getDayOfWeek());
		//getWeekDay -- ENUM
	}

	@Test
	public void shouldReturnTime() {
		assertThat(dateTime.returnTime("23:23"), is(LocalTime.class));
		LocalTime localTime = dateTime.returnTime("23:23");
		System.out.println(localTime);
	}

}
