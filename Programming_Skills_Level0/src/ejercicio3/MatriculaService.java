package ejercicio3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatriculaService {
	private List<Usuario> usuariosRegistrados;
	private Map<String, Campus> campusDisponible;

	public MatriculaService() {
		this.usuariosRegistrados = new ArrayList<Usuario>();
		this.campusDisponible = new HashMap<String, Campus>();
		crearCampus();
	}

	private void crearCampus() {
		Campus londres = new Campus("Londres");
		Campus manchester = new Campus("Manchester");
		Campus liverpool = new Campus("Liverpool");

		londres.crearProgramas(new String[] { "Informatica", "Medicina", "Marketing", "Artes" }, 1);
		manchester.crearProgramas(new String[] { "Informatica", "Medicina", "Marketing", "Artes" }, 3);
		liverpool.crearProgramas(new String[] { "Informatica", "Medicina", "Marketing", "Artes" }, 1);

		campusDisponible.put("Londres", londres);
		campusDisponible.put("Manchester", manchester);
		campusDisponible.put("Liverpool", liverpool);
	}

	public boolean registrarUsuario(Usuario usuario) {
		Campus campus = campusDisponible.get(usuario.getCampusElegido());
		if (campus != null && campus.getPlazasDisponibles(usuario.getProgramaElegido()) > 0) {
			campus.ocuparPlaza(usuario.getProgramaElegido());
			usuariosRegistrados.add(usuario);
			return true;
		}
		return false;
	}
}
