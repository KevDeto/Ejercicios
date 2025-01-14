package ejercicio4;

public class Paquete {
	private final String paqueteID;
	private final String remitente;
	private final String destinatario;
	private final double peso;

	public Paquete(String paqueteID, String remitente, String destinatario, double peso) {
		this.paqueteID = paqueteID;
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Paquete{" + ", paqueteID='" + paqueteID + '\'' + "remitente='" + remitente + '\'' + ", destinatario='"
				+ destinatario + '\'' + ", peso=" + peso + '}';
	}
}
