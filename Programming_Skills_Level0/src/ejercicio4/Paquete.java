package ejercicio4;

public class Paquete {
    private final String paqueteID;
    private final String remitente;
    private final String destinatario;
    private final double peso;

    public Paquete( String paqueteID, String sender, String recipient, double weight) {
        this.paqueteID = paqueteID;
        this.remitente = sender;
        this.destinatario = recipient;
        this.peso = weight;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                ", paqueteID='" + paqueteID + '\'' +
                "remitente='" + remitente + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", peso=" + peso +
                '}';
    }
}
