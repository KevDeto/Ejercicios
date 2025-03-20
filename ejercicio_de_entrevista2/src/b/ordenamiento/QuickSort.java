package b.ordenamiento;

import java.util.Random;

public class QuickSort {
	public static void quickSort(int[] arr, int izq, int der) {
		if(izq < der) {
			Random random = new Random();
			int pivote = izq + random.nextInt(der - izq + 1);
			
			//intercambio el pivote con el ultimo elemento
			intercambiar(arr,pivote,der);
			
			//particiono el array
			int particion = particionar(arr, izq, der);
			
			//ordeno recursivamente las particiones izquierda y derecha
			quickSort(arr, izq, particion - 1);
			quickSort(arr, particion + 1, der);
		}
	}
	
	public static void intercambiar(int[] arr, int pivote, int der) {
		int aux = arr[pivote];
		arr[pivote] = arr[der];
		arr[der] = aux;
	}
	
	public static int particionar(int[] arr, int izq, int der) {
		int pivote = arr[der];
		int indiceMenores = izq - 1; //inicia en -1
		
		for (int indiceComparador = izq; indiceComparador < der; indiceComparador++) {
			if(arr[indiceComparador] <= pivote) {
				indiceMenores++;
				intercambiar(arr, indiceMenores, indiceComparador);
			}
		}
		
		//coloco el pivote en su posicion correcta
		intercambiar(arr, indiceMenores + 1, der);
		
		//ultimo elemento menor o igual al pivote
		return indiceMenores + 1;
	}
		
    public static void main(String[] args) {
        int[] arr = {2,6,12,523,12,3,9,53,56,45,30,0,19};

        System.out.println("Arreglo original:");
        imprimirArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Arreglo ordenado:");
        imprimirArray(arr);
    }

    private static void imprimirArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
