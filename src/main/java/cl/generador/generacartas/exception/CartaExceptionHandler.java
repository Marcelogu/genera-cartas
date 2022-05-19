package cl.generador.generacartas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class CartaExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({FormatoObjetoException.class, Exception.class})
    public ResponseEntity<Object> formatoObjetoException(Exception e) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("fecha", LocalDateTime.now());
        body.put("mensaje", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


}
