package ejercicio1;

public class Usuario {
	private String nombre;
	private String contraseña;
	
	public Usuario() {
	}
	
	public void crearUsuario(String nombre, String contraseña) {
		setNombre(nombre);
		setContraseña(contraseña);
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
}
