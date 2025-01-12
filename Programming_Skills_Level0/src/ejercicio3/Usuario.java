package ejercicio3;

public class Usuario {
	private String username;
	private String password;
	private String nombre;
	private String apellido;
	private String programaElegido;
	private String campusElegido;

	public Usuario(String username, String password, String nombre, String apellido, String programaElegido,
			String campusElegido) {
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.programaElegido = programaElegido;
		this.campusElegido = campusElegido;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getProgramaElegido() {
		return programaElegido;
	}

	public void setProgramaElegido(String programaElegido) {
		this.programaElegido = programaElegido;
	}

	public String getCampusElegido() {
		return campusElegido;
	}

	public void setCampusElegido(String campusElegido) {
		this.campusElegido = campusElegido;
	}
}
