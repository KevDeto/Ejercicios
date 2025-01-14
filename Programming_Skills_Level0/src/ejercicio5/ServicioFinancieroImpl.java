package ejercicio5;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ServicioFinancieroImpl implements ServicioFinanciero{
	private final Map<CategoriaGasto, List<Gasto>> gastosPorCategoria = new EnumMap<>(CategoriaGasto.class);

    public ServicioFinancieroImpl() {
        for (CategoriaGasto categoria : CategoriaGasto.values()) {
            gastosPorCategoria.put(categoria, new ArrayList<>());
        }
    }

    @Override
    public void agregarGasto(Gasto gasto) {
        gastosPorCategoria.get(gasto.getCategoria()).add(gasto);
    }

    @Override
    public double obtenerGastoTotal() {
        return gastosPorCategoria.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Gasto::getMonto)
                .sum();
    }

    @Override
    public double obtenerTotalPorCategoria(CategoriaGasto categoria) {
        return gastosPorCategoria.get(categoria).stream()
                .mapToDouble(Gasto::getMonto)
                .sum();
    }

    @Override
    public Map<CategoriaGasto, List<Gasto>> listarGastosPorCategoria() {
        return gastosPorCategoria;
    }

    @Override
    public String evaluarSaludFinanciera(double ingresosTotales) {
        double gastosTotales = obtenerGastoTotal();
        if (gastosTotales == ingresosTotales) {
            CategoriaGasto categoriaMayorGasto = gastosPorCategoria.entrySet().stream()
                    .max((entry1, entry2) -> Double.compare(
                            obtenerTotalPorCategoria(entry1.getKey()), obtenerTotalPorCategoria(entry2.getKey())))
                    .map(Map.Entry::getKey).orElse(null);
            return "Tus gastos coinciden con tus ingresos. Considera reducir los gastos en la categoría " 
                    + (categoriaMayorGasto != null ? categoriaMayorGasto.getNombre() : "principal") + ".";
        } else if (gastosTotales < ingresosTotales) {
            return "¡Felicitaciones! Estás gastando sabiamente y ahorrando dinero.";
        } else {
            return "Tus gastos superan tus ingresos. Considera revisar y reducir los gastos innecesarios.";
        }
    }
}
