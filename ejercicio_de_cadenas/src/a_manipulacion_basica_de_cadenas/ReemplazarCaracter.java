package a_manipulacion_basica_de_cadenas;

public class ReemplazarCaracter {
	//reemplazar todas las apariciones de un caracter por otro
	public static String reemplazarCaracterPorOtro(String cadena, char caracter, char nuevo) {
		String nueva = "";
		for (int i = 0; i < cadena.length(); i++) {
			if(cadena.charAt(i) !=  caracter) {
				nueva += cadena.charAt(i);
			}else{
				nueva += nuevo;
			}
		}
		return nueva;
	}
	
	public static String reemplazarCaracterPorOtro2(String cadena, char caracter, char nuevo) {
		if(cadena.length() == 0) {
			return "";
		}
		if(cadena.charAt(0) ==  caracter) {
			return String.valueOf(nuevo) + reemplazarCaracterPorOtro2(resto(cadena), caracter, nuevo);
		}
		return String.valueOf(cadena.charAt(0)) + reemplazarCaracterPorOtro2(resto(cadena), caracter, nuevo);
	}
	
	public static String resto(String cadena) {
		String nueva = "";
		for (int i = 1; i < cadena.length(); i++) {
			nueva += cadena.charAt(i);
		}
		return nueva;
	}
	
	public static void main(String[] args) {
		System.out.println(reemplazarCaracterPorOtro("palabra", 'a', 'm'));
		System.out.println(reemplazarCaracterPorOtro2("palabra", 'r', 's'));
	}
}
