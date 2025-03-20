package a.busqueda_y_estructura_de_datos;

import java.util.ArrayList;

public class EliminarDuplicados {

	// Eliminar duplicados en un array sin estructuras adicionales
	public static int[] eliminarDuplicados(int[] nums) {
		java.util.Arrays.sort(nums);
		int cantRepe = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				cantRepe++;
			}
		}
		int j = 0;
		int[] nueva = new int[nums.length - cantRepe];
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != nums[i + 1]) {
				nueva[j] = nums[i];
				j++;
			}
		}
		nueva[j] = nums[nums.length - 1];
		return nueva;
	}

	public static void main(String[] args) {
		int[] lista = { 4, 2, 2, 4, 1, 3, 3, 4, 4, 3, 2, 1, 3, 4, 1, 2, 3, 3, 1, 2, 3 };
		for (int a : lista) {
			System.out.print(a);
		}
		System.out.println();
		for (int a : eliminarDuplicados(lista)) {
			System.out.print(a);
		}
	}
}
