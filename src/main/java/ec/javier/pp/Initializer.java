package ec.javier.pp;

public class Initializer {

	public static void main(String[] args) {
		System.out.println("It works!");
		
		if (args.length < 1) {
			System.out.println("Please insert the vehicule data, date and time");
			System.out.println("Please restart");
			System.exit(0);
		}
		
		System.out.println("Placa: " + args[0] );
		System.out.println("Fecha: " + args[1] );
		System.out.println("Horas: " + args[2] );

	}

}
