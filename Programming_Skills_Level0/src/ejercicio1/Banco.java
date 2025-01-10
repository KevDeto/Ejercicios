package ejercicio1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Banco {
	private Map<String, String> usuarios;
	private Cuenta cuenta;
	private Operacion operacion;
	private int intentos;

	public Banco() {
		this.usuarios = new HashMap<String, String>();
		this.cuenta = null;
		this.operacion = null;
		this.intentos = 0;
	}

	public static void main(String[] args) {
		Banco banco = new Banco();
		Scanner sc = new Scanner(System.in);
		String username;
		String password;

		banco.crearUsuario("kevin123", "12345");
		
		while(banco.intentos < 3) {
			System.out.println("Ingrese su nombre de usuario: ");
			username = sc.nextLine();
			System.out.println("Ingrese su contraseña: ");
			password = sc.nextLine();

			if (!banco.existeUsuarioEnSistema(username)) {
				System.out.println("El usuario no existe, intente de nuevo.");
			} else {
				if (banco.verificarUsuario(username, password)) {
					System.out.println("dentro");
				}
			}

			banco.intentos++;
		}
		System.out.println("Demasiados intentos.");
		sc.close();
	}

	public boolean existeUsuarioEnSistema(String username) {
		return usuarios.containsKey(username);
	}

	public void crearUsuario(String username, String password) {
		usuarios.put(username, password);
	}

	public boolean verificarUsuario(String username, String password) {
		return usuarios.get(username).equals(password);
	}
}
