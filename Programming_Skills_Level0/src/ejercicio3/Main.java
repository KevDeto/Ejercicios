package ejercicio3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		MenuService menuService = new MenuService();
		LoginService loginService = new LoginService();
		MatriculaService matriculaService = new MatriculaService();
		
		Usuario marcos = new Usuario("mark123", "12345", "marcos", "aguirre", "Informatica", "Liverpool");
		Usuario sofia = new Usuario("pops25", "contraseña", "sofia", "gutierrez", "Artes", "Manchester");
		Usuario rodrigo = new Usuario("rodru", "123", "rodrigo", "rocha", "Marketing", "Londres");
		Usuario ricardo = new Usuario("ricky", "12345", "ricardo", "centurion", "Marketing", "Londres");
		
		Usuario[] lista ={marcos,sofia,rodrigo,ricardo};
		for (Usuario usuario : lista) {
			loginService.registrarse(usuario.getUsername(), usuario.getPassword());
			matriculaService.registrarUsuario(usuario);
		}
		
		Scanner scan = new Scanner(System.in);
		menuService.mostrarMenuPrincipal();
		int primerInput = scan.nextInt();	
		if(primerInput == 2) {
			System.out.println("Ingrese sus credenciales");
			System.out.print("Username: ");
			String username = scan.next();
			System.out.print("Password: ");
			String password = scan.next();
			
			scan.nextLine();
			
			if (loginService.autenticacion(username, password)) {
				menuService.mostrarMenuProgramas();
			}
		}
		scan.close();
	}
}
