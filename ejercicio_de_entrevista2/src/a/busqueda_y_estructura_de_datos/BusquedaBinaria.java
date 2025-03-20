package a.busqueda_y_estructura_de_datos;

public class BusquedaBinaria {

	//Implementa una función que busque un número en una lista ordenada usando búsqueda binaria.
	public int busquedaBinaria(int[] arr, int objetivo) {
		int izquierda = 0, derecha = arr.length - 1;

		while (izquierda < derecha) {
			int medio = izquierda + (derecha - izquierda) / 2;

			if (objetivo == arr[medio]) {
				return medio;
			}

			if (objetivo < arr[medio]) {
				derecha = medio - 1;
			} else {
				izquierda = medio + 1;
			}
		}
		return -1;
	}

	public int busquedaBinariaRecursiva(int[] arr, int objetivo, int izq, int der) {
		if (izq < der) {
			int medio = izq + (der - izq) / 2;
			if (objetivo == arr[medio]) {
				return medio;
			}
			if (objetivo < arr[medio]) {
				return busquedaBinariaRecursiva(arr, objetivo, izq, medio - 1);
			} else {
				return busquedaBinariaRecursiva(arr, objetivo, medio + 1, der);
			}
		}
		return -1;
	}

}
