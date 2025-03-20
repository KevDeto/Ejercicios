package a_manipulacion_basica_de_cadenas;

public class ContarVocales {
	//dado un string contar cuantas vocales tiene
	public static int contarVocalesEnCadena(String cadena) {
		int cant = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if(String.valueOf(cadena.charAt(i)).matches("[aeiouAEIOU]"))
			cant++;
		}
		return cant;
	}
	
	public static int contarVocalesEnCadena2(String cadena) {
		if(cadena.length() == 0) {
			return 0;
		}
		if(String.valueOf(cadena.charAt(0)).matches("[aeiouAEIOU]")) {
			return 1 + contarVocalesEnCadena2(resto(cadena));
		}
		return contarVocalesEnCadena(resto(cadena));
	}
	
	public static String resto(String cadena) {
		String nueva = "";
		for (int i = 1; i < cadena.length(); i++) {
			nueva += cadena.charAt(i); 
		}
		return nueva;
	}
	
	public static void main(String[] args) {
		System.out.println(contarVocalesEnCadena("Eufonia"));
		System.out.println(contarVocalesEnCadena2("b"));
	}
}
