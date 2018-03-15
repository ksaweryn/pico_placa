/**
 * Class License.java created 13 Mar 2018
 */
package ec.javier.pp.license;

/**
 * Process vehicle license data
 * 
 * @author Javier Borja
 *
 */
public class License {

	/**
	 * Returns the last digit of license
	 * 
	 * @param licenseNumber
	 *            String form the vehicle license
	 * @return int
	 */
	public static Integer returnLastLicenseCharacter(String licenseNumber) {
		try {
			return Integer.valueOf(licenseNumber.substring(licenseNumber.length() - 1, licenseNumber.length()));
		} catch (NumberFormatException e) {
			System.out.println("Please insert the vehicle license in the next pattern POK0808");
			System.out.println("Please restart");
			System.exit(0);
		}
		return null;
	}

	/**
	 * Returns the day of the week that the vehicle has 'Pico y Placa' restriction
	 * 
	 * @param digit
	 *            int
	 * @return int the day of the week restriction
	 */
	public static int returnRestrictionDay(int digit) {
		int day = digit;
		if (digit % 2 > 0) {
			day += 1;
		}
		return day / 2;
	}

}
