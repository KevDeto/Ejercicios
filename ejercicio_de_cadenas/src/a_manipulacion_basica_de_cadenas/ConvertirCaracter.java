package a_manipulacion_basica_de_cadenas;

public class ConvertirCaracter {
	//Convertir manualmente un string a minúsculas o mayúsculas (sin usar toLowerCase() o toUpperCase()).
	public static String convertirCaracter(String cadena) {
		String nueva = "";
		for (int i = 0; i < cadena.length(); i++) {
			if(cadena.charAt(i) >= 'a' && cadena.charAt(i) <= 'z' ) {
				nueva += (char)(cadena.charAt(i) - 32);
			}
			if(cadena.charAt(i) >= 'A' && cadena.charAt(i) <= 'Z' ) {
				nueva += (char)(cadena.charAt(i) + 32);
			}
		}
		return nueva;
	}
	
	public static String convertirCaracter2(String cadena) {
		if(cadena.length() == 0) {
			return "";
		}
		if(cadena.charAt(0) >= 'a' && cadena.charAt(0) <= 'z' ) {
			return (char)(cadena.charAt(0) - 32) + convertirCaracter2(resto(cadena));
		}
		if(cadena.charAt(0) >= 'A' && cadena.charAt(0) <= 'Z' ) {
			return (char)(cadena.charAt(0) + 32) + convertirCaracter2(resto(cadena));
		}
		return convertirCaracter2(resto(cadena));
	}
	
	public static String resto(String cadena) {
		String nueva = "";
		for (int i = 1; i < cadena.length(); i++) {
			nueva += cadena.charAt(i);
		}
		return nueva;
	}
	
	public static void main(String[] args) {
		System.out.println(convertirCaracter("PalaBrA"));
		System.out.println(convertirCaracter2("PalaBrA"));
	}
}
