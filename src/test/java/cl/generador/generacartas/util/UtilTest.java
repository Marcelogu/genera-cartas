package cl.generador.generacartas.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilTest {


    Util util;


    @Test
    void generaArchivoTest(){

        util = new Util();
        final byte[] generado = util.generaArchivo("Concepción", "Marcelo", "Balmaceda 785", "marcelo@g.com", "José", "Orompello 768");

        assertTrue(generado.length > 0);
    }
}