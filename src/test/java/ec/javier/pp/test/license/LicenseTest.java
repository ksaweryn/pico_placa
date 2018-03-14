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

	private static String licenseNumber;
	private static License license;

	@Before
	public void initializer() {
		licenseNumber = "POK0808";
		license = new License(licenseNumber);

	}

	@Test
	public void shouldReturnLastLicenseCharacter() {
		char lastCharacter = license.returnLastLicenseCharacter(licenseNumber);
		assertEquals('8', lastCharacter);

	}

}
