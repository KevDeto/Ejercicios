package ejercicio3;

import java.util.HashMap;
import java.util.Map;

public class LoginService {
	private Map<String, String> credenciales;
	private Map<String, Integer> intentosFallidos;
	
	public LoginService() {
		this.credenciales = new HashMap<String, String>();
		this.intentosFallidos = new HashMap<String, Integer>();
	}
	
	public void guardarCredenciales(String username, String password) {
		if(credenciales.containsKey(username)) {
			throw new RuntimeException("El usuario ya existe");
		}
		credenciales.put(username, password);
		intentosFallidos.put(username, 3);
	}
	
	public boolean autenticacion(String username, String password) {
		if(credenciales.containsKey(username)) {
			if(credenciales.get(username).equals(password)) {
				return true;
			}
		}
		intentosFallidos.replace(username, intentosFallidos.get(username) - 1);
		return false;
	}
	
	public boolean estaBloqueado(String username) {
		return intentosFallidos.get(username) > 0;
	}
	
	public void registrarse(String username, String password) {
		credenciales.put(username, password);
	}
}
