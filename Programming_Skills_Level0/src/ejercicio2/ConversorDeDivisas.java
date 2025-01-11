package ejercicio2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConversorDeDivisas {
	private Map<String, Divisa> divisas;

	public ConversorDeDivisas() {
		this.divisas = new HashMap<String, Divisa>();
		crearDivisas();
	}

	private void crearDivisas() {
		divisas.put("CLP",
				new Divisa("CLP", new BigDecimal(1000), new BigDecimal(1000000), new BigDecimal(0.000988132)));
		divisas.put("ARS", new Divisa("ARS", new BigDecimal(100), new BigDecimal(500000), new BigDecimal(0.000964782)));
		divisas.put("USD", new Divisa("USD", new BigDecimal(1), new BigDecimal(10000), new BigDecimal(1.0)));
		divisas.put("EUR", new Divisa("EUR", new BigDecimal(1), new BigDecimal(10000), new BigDecimal(1.02507)));
		divisas.put("TRY", new Divisa("TRY", new BigDecimal(10), new BigDecimal(50000), new BigDecimal(0.0282542)));
		divisas.put("GBP", new Divisa("GBP", new BigDecimal(1), new BigDecimal(10000), new BigDecimal(1.22163)));
	}
	
	private BigDecimal retirarFondos(BigDecimal fondosARetirar, BigDecimal saldoActual) {
		BigDecimal montoRetirar = fondosARetirar;
		montoRetirar = montoRetirar.multiply(new BigDecimal(0.01));
		montoRetirar = montoRetirar.subtract(fondosARetirar);
		montoRetirar = montoRetirar.add(saldoActual);
		return montoRetirar;
	}

	private BigDecimal convertirDivisa(BigDecimal monto, Divisa monedaInicial, Divisa monedafinal) {
		BigDecimal montoFinal = monto;
		montoFinal = montoFinal.multiply(monedaInicial.getTasaDeCambio());
		montoFinal = montoFinal.divide(monedafinal.getTasaDeCambio());
		return montoFinal;
	}

	public static void main(String[] args) {
		ConversorDeDivisas sistema = new ConversorDeDivisas();
		boolean bandera = true;
		Scanner sc = new Scanner(System.in);
		while (bandera) {
			System.out.println("1. CLP\t2. ARS\t3. USD\n4. EUR\t5. TRY\t6. GBP");
			System.out.println("Ingrese el nombre de su moneda inicial: ");
			String monedaInicial = sc.nextLine().toUpperCase();

			System.out.println("Ingrese el nombre de la moneda a la que quiere cambiar: ");
			String monedafinal = sc.nextLine().toUpperCase();

			Divisa divisaInicial = sistema.divisas.get(monedaInicial);
			Divisa divisaFinal = sistema.divisas.get(monedafinal);

			if (divisaInicial != null && divisaFinal != null) {
				System.out.println("Ingrese el monto que desa convertir: ");
				BigDecimal monto = sc.nextBigDecimal();

				BigDecimal montoFinal = sistema.convertirDivisa(monto, divisaInicial, divisaFinal);

				System.out.println("Conversion realizada con exito.");
				System.out.println(
						"Su saldo actual en " + monedafinal + " es: " + montoFinal.setScale(6, RoundingMode.HALF_UP));
				System.out.println("Desea retirar sus fondos ? (ingrese un numero)");
				System.out.println("1. Si\t2. No");
				int eleccion = sc.nextInt();

				if (eleccion < 1 || eleccion > 2) {
					System.out.println("La opcion no existe.");
				} else {
					if (eleccion == 1) {
						System.out.println("Ingrese la cantidad: ");
						BigDecimal montoRetirar = sc.nextBigDecimal();

						if (montoRetirar.compareTo(divisaFinal.getMontoMInimo()) == 1
								&& montoRetirar.compareTo(divisaFinal.getMontoMaximo()) == -1) {
							BigDecimal saldoRestante = sistema.retirarFondos(montoRetirar, montoFinal);
							System.out.println("Operacion exitosa.");
							System.out.println("Su saldo actual en " + monedafinal + " es: "
									+ saldoRestante.setScale(6, RoundingMode.HALF_UP));

						} else {
							System.out.println("La cantidad debe estar entre " + divisaFinal.getMontoMInimo() + " y "
									+ divisaFinal.getMontoMaximo());

						}
					} else {
						System.out.println("Desea realizar otra operacion ?");
						System.out.println("1.Si\t2.No");
						int eleccion2 = sc.nextInt();

						if (eleccion2 != 1) {
							bandera = false;
						}
					}
				}

			} else {
				System.out.println("Moneda invalida. Intente de nuevo.");
			}
			sc.nextLine();
		}
		System.out.println("Cerrando sesion...");
		sc.close();
	}
}
