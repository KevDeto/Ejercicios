package ejercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();
        EnvioService envioService = new EnvioService();
        Scanner scanner = new Scanner(System.in);

        loginService.crearUsuario("admin", "password");

        System.out.println("Bienvenido al sistema de envío en linea");
        if (!loginService.login(scanner)) {
            System.out.println("Usuario bloqueado. Intente más tarde.");
            return;
        }

        boolean bandera = true;
        while (bandera) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Enviar un paquete\t2. Salir");

            System.out.print("Seleccione una opcion: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                	envioService.realizarEnvio(scanner);
                    break;
                case "2":
                    System.out.println("Saliendo del sistema...");
                    bandera = false;
                    break;
                default:
                    System.out.println("Opción no valida. Intente nuevamente.");
            }
        }
        scanner.close();
    }
}