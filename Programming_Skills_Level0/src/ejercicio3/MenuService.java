package ejercicio3;

public class MenuService {
	public void mostrarMenuPrincipal() {
		System.out.println("Bienvenido al sistema de matrícula universitaria");
		System.out.println("1. Registrarse\t2. Iniciar sesion\t3. Salir");
	}

	public void mostrarMenuProgramas() {
		System.out.println("Seleccione un programa:");
		System.out.println("1. Informática\t2. Medicina\n3. Marketing\t4. Artes");
	}

	public void mostrarMenuCampus() {
		System.out.println("Seleccione un campus:");
		System.out.println("1. Londres\t2. Manchester\t3. Liverpool");
	}
}
