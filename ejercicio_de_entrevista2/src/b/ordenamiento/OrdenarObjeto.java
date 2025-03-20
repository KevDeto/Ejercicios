package b.ordenamiento;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class OrdenarObjeto {
	// ordenar una lista de objetos por multiples criterios
	static class Persona {
		public String nombre;
		public int edad;

		public Persona() {
		}

		public Persona(String nombre, int edad) {
			this.nombre = nombre;
			this.edad = edad;
		}

		public String getNombre() {
			return this.nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getEdad() {
			return this.edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		@Override
		public String toString() {
			return "Nombre: " + nombre + ", Edad: " + edad;
		}
	}

	public static List<Persona> ordenarPersonas(List<Persona> personas) {
		return null;
	}

	public static void quicksort(ArrayList<Persona> personas, int izq, int der, String ordenar) {
		if (izq < der) {
			Random random = new Random();
			int pivote = izq + random.nextInt(der - izq + 1);

			intercambiar(personas, pivote, der);

			int particion = ordenarPor(personas, izq, der, ordenar);

			quicksort(personas, izq, particion - 1, ordenar);
			quicksort(personas, particion + 1, der, ordenar);
		}
	}

	public static int ordenarPor(ArrayList<Persona> personas, int izq, int der, String atributo) {
		int particion = 0;
		if (atributo.equals("nombre")) {
			particion = particionar(personas, izq, der, atributo);
		}
		if (atributo.equals("edad")) {
			particion = particionar(personas, izq, der, atributo);
		}
		return particion;
	}

	public static void intercambiar(ArrayList<Persona> personas, int pivote, int der) {
		Persona aux = personas.get(pivote);
		personas.set(pivote, personas.get(der));
		personas.set(der, aux);
	}

	public static int particionar(ArrayList<Persona> personas, int izq, int der, String atributo) {
		Persona pivote = personas.get(der);
		int indexMenor = izq - 1;

		for (int indexCompara = izq; indexCompara < der; indexCompara++) {
			if (atributo.equals("nombre")) {
				if (personas.get(indexCompara).getNombre().compareTo(pivote.getNombre()) <= 0) {
					indexMenor++;
					intercambiar(personas, indexMenor, indexCompara);
				}
			}else if(atributo.equals("edad")) {
				if (personas.get(indexCompara).getEdad() <= pivote.getEdad()) {
					indexMenor++;
					intercambiar(personas, indexMenor, indexCompara);
				}
			}
		}

		intercambiar(personas, indexMenor + 1, der);

		return indexMenor + 1;
	}

	public static void main(String[] args) {
		// Crear un array de ejemplo
		ArrayList<Persona> personas = new ArrayList<>();
		personas.add(new Persona("Carlos", 25));
		personas.add(new Persona("Ana", 30));
		personas.add(new Persona("Beatriz", 25));
		personas.add(new Persona("Daniel", 20));
		personas.add(new Persona("Alan", 20));

		System.out.println("Ordenar por nombre:");
		
		System.out.println("Array original:");

		for (Persona persona : personas) {
			System.out.println(persona.toString());
		}

		// Ordenar el array manualmente
		quicksort(personas, 0, personas.size() - 1, "nombre");

		System.out.println("\nArray ordenado:");
		for (Persona persona : personas) {
			System.out.println(persona.toString());
		}
		
		System.out.println("Ordenar por edad:");
		
		System.out.println("Array original:");

		for (Persona persona : personas) {
			System.out.println(persona.toString());
		}

		// Ordenar el array manualmente
		quicksort(personas, 0, personas.size() - 1, "edad");

		System.out.println("\nArray ordenado:");
		for (Persona persona : personas) {
			System.out.println(persona.toString());
		}
	}
}
