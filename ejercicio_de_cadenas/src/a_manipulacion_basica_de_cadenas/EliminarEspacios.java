package a_manipulacion_basica_de_cadenas;

public class EliminarEspacios {
	//quitar todos los espacios en blanco de un string
	
	public static String eliminarEspaciosDeCadena(String cadena) {
		String nueva = "";
		for (int i = 0; i < cadena.length(); i++) {
			if(cadena.charAt(i) != ' ') {
				nueva += cadena.charAt(i);
			}
		}
		return nueva;
	}
	
	public static String eliminarEspaciosDeCadena2(String cadena) {
		if(cadena.length() == 0) {
			return "";
		}
		if(cadena.charAt(0) != ' ') {
			return String.valueOf(cadena.charAt(0)) + eliminarEspaciosDeCadena2(resto(cadena));
		}
		return eliminarEspaciosDeCadena2(resto(cadena));
	}
	
	public static String resto(String cadena) {
		String nueva = "";
		for (int i = 1; i < cadena.length(); i++) {
			nueva += cadena.charAt(i);
		}
		return nueva;
	}
	
	public static void main(String[] args) {
		System.out.println(eliminarEspaciosDeCadena("esto es un mensaje con espacios "));
		System.out.println(eliminarEspaciosDeCadena2("esto es un mensaje con espacios "));
	}
}
