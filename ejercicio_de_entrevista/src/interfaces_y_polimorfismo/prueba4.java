package interfaces_y_polimorfismo;

/*
 * Crea una interfaz "Animal" con métodos "hacerRuido" y "comer".
 * Crea clases "Perro", "Gato" y "Pajaro" que implementen la interfaz "Animal".
 * Crea un array de objetos de tipo "Animal" y llama a los métodos de cada objeto.
 */

public class prueba4 {

	public static void main(String[] args) {
		Animal[] animales = new Animal[3];
		animales[0] = new Perro();
		animales[1] = new Gato();
		animales[2] = new Pajaro();

		for (Animal animal : animales) {
			System.out.println(animal.hacerRuido());
			System.out.println(animal.comer());
		}
	}

	public interface Animal {
		public String hacerRuido();

		public String comer();
	}

	public static class Perro implements Animal {

		public Perro() {
		}

		@Override
		public String hacerRuido() {
			StringBuilder sb = new StringBuilder();
			return sb.append("Perro empieza a hacer ruido").toString();
		}

		@Override
		public String comer() {
			StringBuilder sb = new StringBuilder();
			return sb.append("Perro empieza a comer").toString();
		}
	}

	public static class Gato implements Animal {

		public Gato() {
		}

		@Override
		public String hacerRuido() {
			StringBuilder sb = new StringBuilder();
			return sb.append("Gato empieza a hacer ruido").toString();
		}

		@Override
		public String comer() {
			StringBuilder sb = new StringBuilder();
			return sb.append("Gato empieza a comer").toString();
		}
	}

	public static class Pajaro implements Animal {

		public Pajaro() {
		}

		@Override
		public String hacerRuido() {
			StringBuilder sb = new StringBuilder();
			return sb.append("Pajaro empieza a hacer ruido").toString();
		}

		@Override
		public String comer() {
			StringBuilder sb = new StringBuilder();
			return sb.append("Pajaro empieza a comer").toString();
		}
	}
}
