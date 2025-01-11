package ejercicio2;

import java.math.BigDecimal;

public class Divisa {
	private String nombre;
	private BigDecimal montoMInimo;
	private BigDecimal montoMaximo;
	private BigDecimal tasaDeCambio;
	
	public Divisa(String nombre, BigDecimal montoMinimo, BigDecimal montoMaximo, BigDecimal tasaDeCambio) {
		this.nombre = nombre;
		this.montoMInimo = montoMinimo;
		this.montoMaximo = montoMaximo;
		this.tasaDeCambio = tasaDeCambio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getMontoMInimo() {
		return montoMInimo;
	}

	public void setMontoMInimo(BigDecimal montoMInimo) {
		this.montoMInimo = montoMInimo;
	}

	public BigDecimal getMontoMaximo() {
		return montoMaximo;
	}

	public void setMontoMaximo(BigDecimal montoMaximo) {
		this.montoMaximo = montoMaximo;
	}

	public BigDecimal getTasaDeCambio() {
		return tasaDeCambio;
	}

	public void setTasaDeCambio(BigDecimal tasaDeCambio) {
		this.tasaDeCambio = tasaDeCambio;
	}
	
	
}
