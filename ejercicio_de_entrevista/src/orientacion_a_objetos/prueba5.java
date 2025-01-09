package orientacion_a_objetos;

import java.util.ArrayList;
import java.util.List;

/*
 * Crea una clase "Persona" con atributos nombre, edad y una lista de hobbies.
 * Crea un método para agregar hobbies a la lista.
 * Crea una clase "Estudiante" que herede de "Persona" y agregue un atributo "carrera".
 * Crea un objeto de tipo "Estudiante" y muestra toda su información.
 */

public class prueba5 {
	public static void main(String[] args) {
		Estudiante estudiante = new Estudiante("Martin", 35, "tecnico automotor");
		estudiante.agregarHobbies("pescar");
		estudiante.agregarHobbies("videojuegos");

		System.out.println(estudiante.toString());
	}

	public static class Persona {
		private String nombre;
		private int edad;
		private List<String> hobbies;

		public Persona(String nombre, int edad) {
			this.nombre = nombre;
			this.edad = edad;
			this.hobbies = new ArrayList<String>();
		}

		public void agregarHobbies(String hobbie) {
			hobbies.add(hobbie);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			return sb
					.append(" nombre=")
					.append(nombre)
					.append(", edad=")
					.append(edad)
					.append(", hobbies")
					.append(hobbies)
					.toString();
		}
	}

	public static class Estudiante extends Persona {
		private String carrera;

		public Estudiante(String nombre, int edad, String carrera) {
			super(nombre, edad);
			this.carrera = carrera;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			return sb
					.append("Estudiante=")
					.append(super.toString())
					.append(", carrera=")
					.append(carrera)
					.toString();
		}
	}
}
