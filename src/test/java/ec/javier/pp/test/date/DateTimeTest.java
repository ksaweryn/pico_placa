/**
 * Class DateTimeTest.java created 13 Mar 2018
 * Copyright javier All rights reserved
 */
package ec.javier.pp.test.date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import ec.javier.pp.date.DateTime;
import ec.javier.pp.license.License;

/**
 * @author javier
 *
 */
public class DateTimeTest {

	private static String tuesday, thursday, saturday;
	private static String morningUnrestriction, morningRestriction, afternoonUnrestriction, afternoonRestriction;
	private static int licenseLastDigit;

	@Before
	public void initialize() {
		tuesday = "13-03-2018";
		thursday = "15-03-2018";
		saturday = "17-03-2018";
		morningUnrestriction = "06:05";
		morningRestriction = "08:31";
		afternoonUnrestriction = "15:59";
		afternoonRestriction = "17:05";
		licenseLastDigit = 7;
	}

	@Test
	public void shouldReturnDate() {
		assertThat(DateTime.returnDate(tuesday), is(LocalDate.class));
	}

	@Test
	public void shouldDecidePicoPlacaDay() {
		LocalDate localDate = DateTime.returnDate(thursday);
		assertTrue(DateTime.hasPicoPlaca(License.returnRestrictionDay(licenseLastDigit), localDate));

		localDate = DateTime.returnDate(saturday);
		assertFalse(DateTime.hasPicoPlaca(License.returnRestrictionDay(licenseLastDigit), localDate));
	}

	@Test
	public void shouldReturnTime() {
		assertThat(DateTime.returnTime("23:23"), is(LocalTime.class));
	}

	@Test
	public void shouldDecideRestrictionPeriod() {
		LocalTime time = DateTime.returnTime(afternoonRestriction);
		assertTrue(DateTime.isTimeInRestrictionPeriod(time));

		time = DateTime.returnTime(morningUnrestriction);
		assertFalse(DateTime.isTimeInRestrictionPeriod(time));
	}
}
