package ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Escribe un programa que lea una línea de un archivo de texto y la imprima en consola.
 * Maneja la excepción IOException en caso de que ocurra algún error al leer el archivo.
 */

public class prueba3 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		String rutaArchivo = System.getProperty("user.dir") + "/src/ficheros/resources/archivo.txt";

		try (BufferedReader archivoTxt = new BufferedReader(new FileReader(rutaArchivo))) {

			String primeraLinea = archivoTxt.readLine();

			if (primeraLinea != null) {
				System.out.println(sb.append("Primera linea: ").append(primeraLinea).toString());
			} else {
				System.out.println(sb.append("Archivo vacio.").toString());
			}

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
