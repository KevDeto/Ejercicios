package ejercicio5;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        ServicioFinanciero servicio = new ServicioFinancieroImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese sus ingresos totales: $");
        double ingresosTotales = scanner.nextDouble();

        while (true) {
            System.out.println("\n=== Menú de Gestión Financiera ===");
            System.out.println("1. Agregar Gasto");
            System.out.println("2. Ver Gasto Total");
            System.out.println("3. Ver Gastos por Categoría");
            System.out.println("4. Evaluar Salud Financiera");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Elija una categoría:");
                    for (CategoriaGasto categoria : CategoriaGasto.values()) {
                        System.out.println((categoria.ordinal() + 1) + ". " + categoria.getNombre());
                    }
                    int opcionCategoria = scanner.nextInt();
                    CategoriaGasto categoriaSeleccionada = CategoriaGasto.values()[opcionCategoria - 1];
                    System.out.print("Ingrese el monto del gasto: $");
                    double monto = scanner.nextDouble();
                    servicio.agregarGasto(new Gasto(categoriaSeleccionada, monto));
                    System.out.println("¡Gasto agregado correctamente!");
                    break;
                case 2:
                    System.out.println("Gasto Total: $" + servicio.obtenerGastoTotal());
                    break;
                case 3:
                    for (CategoriaGasto categoria : CategoriaGasto.values()) {
                        System.out.println(categoria.getNombre() + ": $" + servicio.obtenerTotalPorCategoria(categoria));
                    }
                    break;
                case 4:
                    System.out.println(servicio.evaluarSaludFinanciera(ingresosTotales));
                    break;
                case 5:
                    System.out.println("Saliendo... ¡Adiós!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}
