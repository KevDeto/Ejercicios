package arrays_y_colecciones;

import java.util.Random;

/*
 * Crea un array de 10 números enteros aleatorios.
 * Ordena el array de menor a mayor utilizando el algoritmo de burbuja.
 * Imprime el array ordenado.
 */

public class prueba1 {
	public static void main(String[] args) {
		
		int[] array = new int[10];

		llenarArreglo(array);
		
		burbleSort(array);
		
		imprimir(array);
	}

	private static void burbleSort(int[] array) {
		boolean huboOrdenamiento;
		for (int i = 0; i < array.length; i++) {
			huboOrdenamiento = false;
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					
					int aux = array[j];
					array[j] = array[j + 1];
					array[j + 1] = aux;
				
					huboOrdenamiento = true;
				}
			}
			
			if(!huboOrdenamiento) {
				break;
			}
		}
	}
	
	private static void llenarArreglo(int[] array) {
		Random random = new Random();
		
		for (int i = 0; i < array.length; i++) {
			int num = random.nextInt(11);
			array[i] = num;
		}
	}
	
	private static void imprimir(int[] array) {
		for(int n : array) {
			System.out.println(n);
		}
	}
}
