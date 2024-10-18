package med.voll.api.infra.errores;


// esta clase es una excepción que se lanza cuando se detecta una violación de la integridad de los datos
// por ejemplo, cuando se intenta eliminar un registro que tiene registros relacionados en otra tabla
public class ValidacionDeIntegridad extends RuntimeException {
    public ValidacionDeIntegridad(String s) {
        super(s);
    }
}