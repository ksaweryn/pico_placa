/**
 * Class DateTimeTest.java created 13 Mar 2018
 */
package ec.javier.pp.test.date;

import static org.hamcrest.CoreMatchers.isA;
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
 * Test class for DateTime class
 * 
 * @author Javier Borja
 *
 */
public class DateTimeTest {

	private static String monday, tuesday, wednesday, thursday, friday, saturday, sunday;
	private static String morningUnrestriction, morningRestriction, afternoonUnrestriction, afternoonRestriction;
	private static final int one = 1;
	private static final int two = 2;
	private static final int three = 3;
	private static final int four = 4;
	private static final int five = 5;
	private static final int six = 6;
	private static final int seven = 7;
	private static final int eight = 8;
	private static final int nine = 9;
	private static final int zero = 10;

	@Before
	public void initialize() {
		monday = "12-03-2018";
		tuesday = "13-03-2018";
		wednesday = "14-03-2018";
		thursday = "15-03-2018";
		friday = "16-03-2018";
		saturday = "17-03-2018";
		sunday = "18-03-2018";
		morningUnrestriction = "06:05";
		morningRestriction = "08:31";
		afternoonUnrestriction = "15:59";
		afternoonRestriction = "17:05";
	}

	@Test
	public void shouldReturnDate() {
		assertThat(DateTime.returnDate(tuesday), isA(LocalDate.class));
	}

	@Test
	public void shouldDecidePicoPlacaDay() {
		LocalDate localDate = DateTime.returnDate(thursday);
		assertFalse(DateTime.hasPicoPlaca(License.returnRestrictionDay(one), localDate));

		localDate = DateTime.returnDate(monday);
		assertTrue(DateTime.hasPicoPlaca(License.returnRestrictionDay(one), localDate));

		localDate = DateTime.returnDate(thursday);
		assertFalse(DateTime.hasPicoPlaca(License.returnRestrictionDay(two), localDate));

		localDate = DateTime.returnDate(monday);
		assertTrue(DateTime.hasPicoPlaca(License.returnRestrictionDay(two), localDate));

		localDate = DateTime.returnDate(monday);
		assertFalse(DateTime.hasPicoPlaca(License.returnRestrictionDay(three), localDate));

		localDate = DateTime.returnDate(tuesday);
		assertTrue(DateTime.hasPicoPlaca(License.returnRestrictionDay(three), localDate));

		localDate = DateTime.returnDate(saturday);
		assertFalse(DateTime.hasPicoPlaca(License.returnRestrictionDay(four), localDate));

		localDate = DateTime.returnDate(tuesday);
		assertTrue(DateTime.hasPicoPlaca(License.returnRestrictionDay(four), localDate));

		localDate = DateTime.returnDate(friday);
		assertFalse(DateTime.hasPicoPlaca(License.returnRestrictionDay(five), localDate));

		localDate = DateTime.returnDate(wednesday);
		assertTrue(DateTime.hasPicoPlaca(License.returnRestrictionDay(six), localDate));

		localDate = DateTime.returnDate(sunday);
		assertFalse(DateTime.hasPicoPlaca(License.returnRestrictionDay(seven), localDate));

		localDate = DateTime.returnDate(thursday);
		assertTrue(DateTime.hasPicoPlaca(License.returnRestrictionDay(eight), localDate));

		localDate = DateTime.returnDate(saturday);
		assertFalse(DateTime.hasPicoPlaca(License.returnRestrictionDay(nine), localDate));

		localDate = DateTime.returnDate(friday);
		assertTrue(DateTime.hasPicoPlaca(License.returnRestrictionDay(nine), localDate));

		localDate = DateTime.returnDate(thursday);
		assertFalse(DateTime.hasPicoPlaca(License.returnRestrictionDay(zero), localDate));

		localDate = DateTime.returnDate(friday);
		assertTrue(DateTime.hasPicoPlaca(License.returnRestrictionDay(zero), localDate));

	}

	@Test
	public void shouldReturnTime() {
		assertThat(DateTime.returnTime("23:23"), isA(LocalTime.class));
	}

	@Test
	public void shouldDecideRestrictionPeriod() {
		LocalTime time = DateTime.returnTime(afternoonRestriction);
		assertTrue(DateTime.isTimeInRestrictionPeriod(time));

		time = DateTime.returnTime(morningUnrestriction);
		assertFalse(DateTime.isTimeInRestrictionPeriod(time));

		time = DateTime.returnTime(morningRestriction);
		assertTrue(DateTime.isTimeInRestrictionPeriod(time));

		time = DateTime.returnTime(afternoonUnrestriction);
		assertFalse(DateTime.isTimeInRestrictionPeriod(time));
	}
	
	@Test
	public void test() {
		
	}
}
