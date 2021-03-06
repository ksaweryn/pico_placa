/**
 * Class Initializer.java created 13 Mar 2018
 */
package ec.javier.pp;

import java.time.LocalDate;
import java.time.LocalTime;

import ec.javier.pp.date.DateTime;
import ec.javier.pp.license.License;

/**
 * 
 * @author Javier Borja
 *
 */
public class Initializer {

	/**
	 * Main method 
	 * 
	 * @param args
	 *            from console
	 */
	public static void main(String[] args) {

		String license;
		String date;
		String time;

		if (args.length != 3) {
			System.out.println("Please insert the vehicle license, date and time");
			System.out.println("Please restart");
			System.exit(0);
		}

		System.out.println("License: " + args[0].toUpperCase());
		System.out.println("Date: " + args[1]);
		System.out.println("Time: " + args[2]);

		license = args[0];
		date = args[1];
		time = args[2];

		int lastNumber = License.returnLastLicenseNumber(license);

		LocalDate localDate = DateTime.returnDate(date);
		LocalTime localTime = DateTime.returnTime(time);

		if (DateTime.hasPicoPlaca(License.returnRestrictionDay(lastNumber), localDate)) {
			if (DateTime.isTimeInRestrictionPeriod(localTime)) {
				System.out.println(
						"Your car with license " + license + " HAS 'Pico y Placa' the " + date + " at " + time);
			} else {
				System.out.println("Your car with license " + license + " DOES NOT have 'Pico y Placa' the " + date
						+ " at " + time);
			}
		} else {
			System.out.println("Your car with license " + license + " DOES NOT have 'Pico y Placa' the " + date);
		}
	}

}
