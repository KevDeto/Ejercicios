package ejercicio1;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Banco {
	private Map<String, String> usuarios;
	private Map<String, Cuenta> cuentas;
	private int intentos;

	public Banco() {
		this.usuarios = new HashMap<String, String>();
		this.cuentas = new HashMap<String, Cuenta>();
		this.intentos = 3;
	}

	public static void main(String[] args) {
		Banco banco = new Banco();
		Scanner sc = new Scanner(System.in);
		String username;
		String password;
		boolean bandera = true;

		banco.crearUsuario("kevin123", "12345");
		banco.crearUsuario("kevin", "123");

		while (bandera && banco.intentos > 0) {
			System.out.println("Ingrese su nombre de usuario: ");
			username = sc.nextLine();

			if (banco.existeUsuarioEnSistema(username)) {
				System.out.println("Ingrese su contraseña: ");
				password = sc.nextLine();

				if (banco.verificarUsuario(username, password)) {
					System.out.println("Seleccionar el numero de operacion:");
					System.out.println("1. Ver saldo\t2. Retirar\n3. Depositar\t4. Transferir\t5. Salir");
					int operacionElegida = sc.nextInt();
					sc.nextLine();

					switch (operacionElegida) {
					case 1: // ver saldo
						banco.operacionVerSaldo(username);
						break;

					case 2: // retirar
						System.out.print("Ingrese el monto a extraer: $");
						BigDecimal montoRetiro = sc.nextBigDecimal();
						banco.operacionRetirar(username, montoRetiro);
						sc.nextLine();
						break;

					case 3: // depositar
						System.out.print("Ingrese el monto a depositar: $");
						BigDecimal montoDeposito = sc.nextBigDecimal();
						banco.operacionDepositar(username, montoDeposito);
						sc.nextLine();
						break;

					case 4: // transferir
						System.out.print("Ingrese el nombre de usuario a transferir: ");
						String cuentaDestino = sc.nextLine();
						System.out.print("Ingrese el monto: ");
						BigDecimal montoTransferencia = sc.nextBigDecimal();
						banco.operacionTransferir(username, montoTransferencia, cuentaDestino);
						sc.nextLine();
						break;

					case 5: // salir
						System.out.println("Cerrando sesion...");
						bandera = false;
						break;

					default:
						System.out.println("Operacion no válida");
						sc.nextLine();
						break;
					}
				} else {
					banco.intentos--;
					System.out.println("Contraseña incorrecta. Intentos restantes: " + banco.intentos);
				}
			} else {
				banco.intentos--;
				System.out.println("Usuario incorrecto. Intentos restantes: " + banco.intentos);
			}
		}
		sc.close();
	}

	private boolean existeUsuarioEnSistema(String username) {
		return usuarios.containsKey(username);
	}

	private void crearUsuario(String username, String password) {
		usuarios.put(username, password);
		cuentas.put(username, new Cuenta());
	}

	private boolean verificarUsuario(String username, String password) {
		return usuarios.get(username).equals(password);
	}

	private void operacionVerSaldo(String username) {
		Cuenta cuenta = buscarCuentaDeUsuario(username);
		cuenta.verSaldo();
	}

	private void operacionRetirar(String username, BigDecimal monto) {
		Cuenta cuenta = buscarCuentaDeUsuario(username);
		cuenta.retirarSaldo(monto);
	}

	private void operacionDepositar(String username, BigDecimal monto) {
		Cuenta cuenta = buscarCuentaDeUsuario(username);
		cuenta.depositarSaldo(monto);
	}

	private void operacionTransferir(String username, BigDecimal monto, String usernameDestino) {
		Cuenta cuenta = buscarCuentaDeUsuario(username);
		Cuenta cuentaDestino = buscarCuentaDeUsuario(usernameDestino);
		cuenta.transferirSaldo(monto, cuentaDestino);
	}

	private Cuenta buscarCuentaDeUsuario(String username) {
		return cuentas.get(username);
	}
}
