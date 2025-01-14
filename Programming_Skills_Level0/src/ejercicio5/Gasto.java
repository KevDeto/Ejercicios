package ejercicio5;

public class Gasto {
	private CategoriaGasto categoria;
	private double monto;

	public Gasto(CategoriaGasto categoria, double monto) {
		if (monto <= 0) {
			throw new IllegalArgumentException("El monto debe ser mayor a cero.");
		}
		this.categoria = categoria;
		this.monto = monto;
	}

	public CategoriaGasto getCategoria() {
		return categoria;
	}

	public double getMonto() {
		return monto;
	}
}
