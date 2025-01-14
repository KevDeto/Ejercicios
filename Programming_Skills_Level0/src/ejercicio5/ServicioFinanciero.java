package ejercicio5;

import java.util.List;
import java.util.Map;

public interface ServicioFinanciero {
    void agregarGasto(Gasto gasto);
    double obtenerGastoTotal();
    double obtenerTotalPorCategoria(CategoriaGasto categoria);
    Map<CategoriaGasto, List<Gasto>> listarGastosPorCategoria();
    String evaluarSaludFinanciera(double ingresosTotales);
}
