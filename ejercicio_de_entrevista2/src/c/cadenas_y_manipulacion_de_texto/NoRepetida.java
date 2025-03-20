package c.cadenas_y_manipulacion_de_texto;

public class NoRepetida {
	// encontrar la primera letra no repetida en una cadena

    public static char primeraNoRepetida(String s) {
        for (int i = 0; i < s.length(); i++) {
            char actual = s.charAt(i);
            boolean repetido = false;

            for (int j = 0; j < s.length(); j++) {
                if (i != j && actual == s.charAt(j)) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                return actual;
            }
        }
        return '\0';
    }

	public static void main(String[] args) {
		System.out.println(primeraNoRepetida("bccboolla"));
	}
}
