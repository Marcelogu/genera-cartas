package cl.generador.generacartas.controller;

import cl.generador.generacartas.entities.Cartas;
import cl.generador.generacartas.services.CartasService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = CartasController.class)
class CartasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    CartasService cartaService;

    final byte[] bytes = new byte[0];

    Cartas carta;

    @Test
    void requestGeneraCartaOk() throws Exception {

        carta = new Cartas("Santiago", "Juan Perez", "Calle 80", "juanperez@juanp.cl", "Benito", "Calle 8");

        when(cartaService.generarCarta(any(Cartas.class))).thenReturn(bytes);

        mockMvc.perform(post("/api/v1/generar-carta")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(carta)))
                .andExpect(status().isOk());

    }

    @Test
    void requestGeneraCartaNoOk() throws Exception {

        carta = new Cartas("Santiago", "Juan Perez", "Calle 80", "juanperez@juanp.cl", "Benito", "Calle 8");

        mockMvc.perform(post("/api/v1/generar-carta")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(carta)))
                .andExpect(status().isNotFound());

    }
}