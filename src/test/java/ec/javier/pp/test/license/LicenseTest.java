/**
 * Class LicenseTest.java created 13 Mar 2018
 */
package ec.javier.pp.test.license;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ec.javier.pp.license.License;

/**
 * Test class for License class
 * @author Javier Borja
 *
 */
public class LicenseTest {

	private static String license;

	@Before
	public void initializer() {
		license = "POK0808";
	}

	@Test
	public void shouldReturnLastLicenseNumber() {
		int lastNumber = License.returnLastLicenseNumber(license);
		assertEquals(8, lastNumber);

	}
	
	@Test
	public void shouldreturnDayOfRestriction() {
		int lastNumber = License.returnLastLicenseNumber(license);
		int day = License.returnRestrictionDay(lastNumber);
		assertEquals(4, day);
	}

}
