/**
 * Class License.java created 13 Mar 2018
 */
package ec.javier.pp.license;

/**
 * 
 * @author Javier Borja
 *
 */
public class License {

	String licenseNumber;

	public License() {

	}

	public License(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public static int returnLastLicenseCharacter(String licenseNumber) {
		return Integer.valueOf(licenseNumber.substring(licenseNumber.length() - 1, licenseNumber.length()));
	}

	public static int returnRestrictionDay(int digit) {
		int day = digit;
		if (digit % 2 > 0) {
			day += 1;
		}
		return day / 2;
	}

}
