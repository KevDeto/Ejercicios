package a_manipulacion_basica_de_cadenas;

public class ContarConsonantes {
	//dado un string contar cuantas consonantes contiene
	
	public static int contarConsonantesEnCadena(String cadena) {
		int cant = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if(String.valueOf(cadena.charAt(i)).matches("[a-zA-Z&&[^aeiouAEIOU]]")) {
				cant++;
			}
		}
		return cant;
	}
	
	public static int contarConsonantesEnCadena2(String cadena) {
		if(cadena.length() == 0) {
			return 0;
		}
		if(String.valueOf(cadena.charAt(0)).matches("[a-zA-Z&&[^aeiouAEIOU]]")) {
			return 1 + contarConsonantesEnCadena2(resto(cadena));
		}
		return contarConsonantesEnCadena2(resto(cadena));
	}
	
	public static String resto(String cadena) {
		String nueva = "";
		for (int i = 1; i < cadena.length(); i++) {
			nueva += cadena.charAt(i);
		}
		return nueva;
	}
	
	public static void main(String[] args) {
		System.out.println(contarConsonantesEnCadena("cualquier cosa"));
		System.out.println(contarConsonantesEnCadena("cualquier cosa"));
	}
}
