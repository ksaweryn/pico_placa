/**
 * Class License.java created 13 Mar 2018
 * Copyright javier All rights reserved
 */
package ec.javier.pp.license;

/**
 * 
 * @author javier
 *
 */
public class License {

	String licenseNumber;

	public License(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public char returnLastLicenseCharacter(String licenseNumber) {
		return licenseNumber.charAt(licenseNumber.length() - 1);
	}

}
