package excepciones;

import java.util.Scanner;

/*
 * Escribe un programa que pida al usuario un número y lo divida entre otro número ingresado por el usuario.
 * Maneja la excepción ArithmeticException en caso de que el divisor sea cero.
 */

public class prueba2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("numero a: ");
		double numeroA = sc.nextInt();
		System.out.print("numero b: ");
		double numeroB = sc.nextInt();
		sc.close();
		
		System.out.println(dividir(numeroA,numeroB));
		
	}
	/*
	 * tambien puedo usar:
	 * throws ArithmeticException
	 * try catch
	 */
	public static double dividir(double numeroA, double numeroB) {
		if(numeroB == 0) {
			throw new ArithmeticException("No se puede dividir por cero");
		}
		return numeroA / numeroB;
	}
}
