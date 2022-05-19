package cl.generador.generacartas.controller;

import cl.generador.generacartas.entities.Cartas;
import cl.generador.generacartas.services.CartasService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1")
public class CartasController {

    private final CartasService cartaService;

    public CartasController(CartasService cartaService) {
        this.cartaService = cartaService;
    }

    @CrossOrigin(origins = "http://localhost", allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    @PostMapping("/generar-carta")
    public ResponseEntity<Resource> generarCarta(@RequestBody Cartas carta) {

        final byte[] bytes = cartaService.generarCarta(carta);

        ByteArrayResource resource = new ByteArrayResource(bytes);

        return ResponseEntity.ok()
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);

    }
}
