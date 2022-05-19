package cl.generador.generacartas.services;

import cl.generador.generacartas.entities.Cartas;
import cl.generador.generacartas.exception.FormatoObjetoException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;


class CartasServiceTest {

    Cartas carta;

    @InjectMocks
    CartasService cartasService;

    private AutoCloseable closeable;

    @BeforeEach
    void init(){
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

    @Test
    void generarCartaNoOk() {
        carta = new Cartas(null, "Juan Perez", "Calle 80", "juanperez@juanp.cl", "Benito", "Calle 8");

        assertThrows(FormatoObjetoException.class, () -> cartasService.generarCarta(carta));

    }
}