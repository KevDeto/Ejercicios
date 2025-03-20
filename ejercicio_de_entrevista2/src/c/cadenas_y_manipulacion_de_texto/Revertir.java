package c.cadenas_y_manipulacion_de_texto;

public class Revertir {
	//Revertir una cadena sin usar Reverse()
	public static String revertirCadena(String input) {
		String cadenaNueva = "";
		for (int i = 0; i < input.length(); i++) {
			cadenaNueva = String.valueOf(input.charAt(i)) + cadenaNueva;
		}
		return cadenaNueva;
	}
	
	public static void main(String[] args) {
		System.out.println(revertirCadena("electroencefalografista"));
	}
}
