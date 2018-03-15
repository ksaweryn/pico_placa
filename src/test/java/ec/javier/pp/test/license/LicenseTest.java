/**
 * Class LicenseTest.java created 13 Mar 2018
 * Copyright javier All rights reserved
 */
package ec.javier.pp.test.license;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ec.javier.pp.license.License;

/**
 * @author javier
 *
 */
public class LicenseTest {

	private static String license;

	@Before
	public void initializer() {
		license = "POK0808";

	}

	@Test
	public void shouldReturnLastLicenseCharacter() {
		int lastCharacter = License.returnLastLicenseCharacter(license);
		assertEquals(8, lastCharacter);

	}
	
	@Test
	public void shouldreturnDayOfRestriction() {
		int lastCharacter = License.returnLastLicenseCharacter(license);
		int day = License.returnRestrictionDay(lastCharacter);
		assertEquals(4, day);
	}

}
