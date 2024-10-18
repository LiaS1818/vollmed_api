package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //Proxy de errores, programacion orientada a espectos
public class TratadorDeErrores {

    //Error 500
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErrores404(){
        return ResponseEntity.notFound().build();
    }

    //tratnado el error 404
    @ExceptionHandler(MethodArgumentNotValidException.class)// Traemos las Exepciones que hay en el cliente
    public ResponseEntity tratarErrores400(MethodArgumentNotValidException e){ //Recibve como parametro la excepcion segun la queramos implementar

        var errores = e.getFieldErrors().stream().map(DatosErrorDeValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    public record DatosErrorDeValidacion(String nombre, String error){
        public DatosErrorDeValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }


}
