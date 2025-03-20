package c.cadenas_y_manipulacion_de_texto;

public class Anagrama {
	//Verificar si una palabra es un anagrama de otra
	
	public static boolean sonAnagramas(String s1, String s2) 
	{ 
		String[] palabra1 = s1.split("");
		String[] palabra2 = s2.split("");
		java.util.Arrays.sort(palabra1);
		java.util.Arrays.sort(palabra2);
		
		for (int i = 0; i < palabra1.length; i++) {
			if(!palabra1[i].equals(palabra2[i])) {
				return false;
			}
		}
		return true;
	}
	
    public static boolean sonAnagramas2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] frecuenciaS1 = new int[26];
        int[] frecuenciaS2 = new int[26];
        //'a' = 97
        for (int i = 0; i < s1.length(); i++) {
            frecuenciaS1[s1.charAt(i) - 'a']++;
            frecuenciaS2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (frecuenciaS1[i] != frecuenciaS2[i]) {
                return false;
            }
        }

        return true;
    }
	
	public static void main(String[] args) {
		System.out.println(sonAnagramas2("cabello", "cebolla"));
	}
}
