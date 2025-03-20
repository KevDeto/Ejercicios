package a_manipulacion_basica_de_cadenas;

public class EliminarCaracter {
	//remover todas las apariciones de un caracter dado una cadena
	
	public static String removerAparicionesEnCadena(String cadena, char caracter) {
		String nueva = "";
		for (int i = 0; i < cadena.length(); i++) {
			if(cadena.charAt(i) !=  caracter) {
				nueva += cadena.charAt(i);
			}
		}
		return nueva;
	}
	
	public static String removerAparicionesEnCadena2(String cadena, char caracter) {
		if(cadena.length() == 0) {
			return "";
		}
		if(cadena.charAt(0) !=  caracter) {
			return String.valueOf(cadena.charAt(0)) + removerAparicionesEnCadena2(resto(cadena), caracter);
		}
		return removerAparicionesEnCadena2(resto(cadena), caracter);
	}
	
	public static String resto(String cadena) {
		String nueva = "";
		for (int i = 1; i < cadena.length(); i++) {
			nueva += cadena.charAt(i);
		}
		return nueva;
	}
	
	public static void main(String[] args) {
		System.out.println(removerAparicionesEnCadena("palabra", 'a'));
		System.out.println(removerAparicionesEnCadena2("palabra", 'b'));
	}
}
