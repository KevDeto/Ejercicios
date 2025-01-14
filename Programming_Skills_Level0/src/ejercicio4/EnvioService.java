package ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EnvioService {
	private final List<Paquete> paquetes = new ArrayList<>();
	private final Random random = new Random();

	public void realizarEnvio(Scanner scanner) {
		System.out.print("Ingrese el nombre del remitente: ");
		String remitente = scanner.nextLine();

		System.out.print("Ingrese el nombre del destinatario: ");
		String destinatario = scanner.nextLine();

		System.out.print("Ingrese el peso del paquete (kg): ");
		double peso = Double.parseDouble(scanner.nextLine());

		double precio = calcularPrecio(peso);
		String paqueteID = generatePackageId();

		Paquete nuevoPaquete = new Paquete(paqueteID, remitente, destinatario, peso);
		paquetes.add(nuevoPaquete);

		System.out.printf("El paquete con numero %s ha sido registrado.\n", paqueteID);
		System.out.printf("El costo total del envío es: $%.2f\n", precio);

		System.out.print("¿Desea realizar otra operacion? (si/no): ");
		String respuesta = scanner.nextLine();

		if (!respuesta.equalsIgnoreCase("si")) {
			System.out.println("Gracias por usar el sistema de envio. ¡Adios!");
			System.exit(0);
		}
	}

	private double calcularPrecio(double peso) {
		return peso * 2;
	}

	private String generatePackageId() {
		return "PQT-" + random.nextInt(10000);
	}
}
