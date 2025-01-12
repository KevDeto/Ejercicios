package ejercicio3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		MenuService menuService = new MenuService();
        LoginService loginService = new LoginService();
        MatriculaService matriculaService = new MatriculaService();

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            menuService.mostrarMenuPrincipal();
            System.out.print("Seleccione una opción: ");
            int opcionPrincipal = scanner.nextInt();
            scanner.nextLine();

            switch (opcionPrincipal) {
                case 1:
                    System.out.println("== REGISTRO DE USUARIO ==");
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();

                    menuService.mostrarMenuProgramas();
                    System.out.print("Seleccione el programa (1-4): ");
                    int opcionPrograma = scanner.nextInt();
                    scanner.nextLine();
                    String programaElegido = obtenerProgramaPorOpcion(opcionPrograma);

                    menuService.mostrarMenuCampus();
                    System.out.print("Seleccione el campus (1-3): ");
                    int opcionCampus = scanner.nextInt();
                    scanner.nextLine();
                    String campusElegido = obtenerCampusPorOpcion(opcionCampus);

                    Usuario nuevoUsuario = new Usuario(username, password, nombre, apellido, programaElegido, campusElegido);
                    try {
                        loginService.registrarse(username, password);
                        if (matriculaService.registrarUsuario(nuevoUsuario)) {
                            System.out.println("Usuario registrado y matriculado exitosamente.");
                        } else {
                            System.out.println("No hay plazas disponibles para el programa en el campus seleccionado.");
                        }
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2: // Iniciar sesión
                    System.out.println("== INICIO DE SESIÓN ==");
                    System.out.print("Username: ");
                    String userLogin = scanner.nextLine();
                    System.out.print("Password: ");
                    String passLogin = scanner.nextLine();

                    if (loginService.autenticacion(userLogin, passLogin)) {
                        System.out.println("Inicio de sesion exitoso.");
                    } else if (!loginService.estaBloqueado(userLogin)) {
                        System.out.println("Cuenta bloqueada. Demasiados intentos.");
                    } else {
                        System.out.println("Credenciales incorrectas. Intente nuevamente.");
                    }
                    break;

                case 3: // Salir
                    salir = true;
                    System.out.println("Cerrando sesion...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
        scanner.close();
	}
	
	private static String obtenerProgramaPorOpcion(int opcion) {
        switch (opcion) {
            case 1: return "Informatica";
            case 2: return "Medicina";
            case 3: return "Marketing";
            case 4: return "Artes";
            default: throw new IllegalArgumentException("Opción de programa no válida.");
        }
    }

    private static String obtenerCampusPorOpcion(int opcion) {
        switch (opcion) {
            case 1: return "Londres";
            case 2: return "Manchester";
            case 3: return "Liverpool";
            default: throw new IllegalArgumentException("Opción de campus no válida.");
        }
    }
}
