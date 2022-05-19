package cl.generador.generacartas.entities;

public class Cartas {

    private final String ciudad;
    private final String destinatario;
    private final String direccionDestinatario;
    private final String correo;
    private final String remitente;
    private final String direccionRemitente;

    public Cartas(String ciudad, String destinatario, String direccionDestinatario, String correo, String remitente, String direccionRemitente) {
        this.ciudad = ciudad;
        this.destinatario = destinatario;
        this.direccionDestinatario = direccionDestinatario;
        this.correo = correo;
        this.remitente = remitente;
        this.direccionRemitente = direccionRemitente;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getDireccionRemitente() {
        return direccionRemitente;
    }
}
