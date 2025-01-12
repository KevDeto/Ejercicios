package ejercicio3;

import java.util.HashMap;
import java.util.Map;

public class Campus {
	private String nombre;
	private Map<String, Integer> plazas;

	public Campus(String nombre) {
		this.nombre = nombre;
		this.plazas = new HashMap<String, Integer>();
	}

	public void crearProgramas(String[] programas, Integer plaza) {
		for (String programa : programas) {
			plazas.put(programa, plaza);
		}
	}

	public Integer getPlazasDisponibles(String programa) {
		return plazas.getOrDefault(programa, 0);
	}

	public void ocuparPlaza(String programa) {
		Integer plaza = plazas.get(programa);
		plazas.replace(programa, plaza-1);
	}
}
