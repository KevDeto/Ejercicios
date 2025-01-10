package ejercicio1;

import java.math.BigDecimal;

public class Cuenta {
	private BigDecimal saldo;
	
	public Cuenta() {
		this.saldo = new BigDecimal(2000.0);
	}
	
	public void depositarSaldo(BigDecimal deposito){
		this.saldo = this.saldo.add(deposito);
	}
	
	public void retirarSaldo(BigDecimal retiro) {
	    if (saldo.compareTo(retiro) >= 0) {
	        this.saldo = this.saldo.subtract(retiro);
	        System.out.println("Retiro exitoso. Nuevo saldo: $" + this.saldo.toString());
	    } else {
	        System.out.println("Saldo insuficiente. Saldo actual: $" + this.saldo.toString());
	    }
	}
	
	public void verSaldo() {
		System.out.println("$"+ this.saldo.toString());
	}
	
	public void transferirSaldo(BigDecimal monto, Cuenta destino) {
	    if (saldo.compareTo(monto) >= 0) {
	        this.saldo = this.saldo.subtract(monto);
	        destino.depositarSaldo(monto);
	        
	        System.out.println("Transferencia realizada. Nuevo saldo: $" + saldo.toString());
	    } else {
	        System.out.println("Saldo insuficiente.");
	    }
	}
}
