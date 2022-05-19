package cl.generador.generacartas.services;

import cl.generador.generacartas.entities.Cartas;
import cl.generador.generacartas.exception.FormatoObjetoException;
import cl.generador.generacartas.util.Util;
import org.springframework.stereotype.Service;

@Service
public class CartasService {
    public byte[] generarCarta(Cartas carta) {

        if(carta.getDestinatario() == null ||
            carta.getDireccionDestinatario() == null ||
            carta.getCiudad() == null ||
            carta.getCorreo() == null ||
            carta.getRemitente() == null ||
            carta.getDireccionRemitente() == null) throw new FormatoObjetoException("Error de formato en los datos ingresados, verifique e intente nuevamente");

        Util util = new Util();

        if(carta.getCiudad().length() <= 100 &&
            carta.getDestinatario().length() <= 100 &&
            carta.getDireccionDestinatario().length() <= 100 &&
            carta.getCorreo().length() <= 100 &&
            carta.getRemitente().length() <= 100 &&
            carta.getDireccionRemitente().length() <= 100) {

            return util.generaArchivo(carta.getCiudad(),
                    carta.getDestinatario(),
                    carta.getDireccionDestinatario(),
                    carta.getCorreo(),
                    carta.getRemitente(),
                    carta.getDireccionRemitente());
        }
        else{
            throw new FormatoObjetoException("El largo máximo permitido por campo es de 100 caracteres");
        }


    }
}
