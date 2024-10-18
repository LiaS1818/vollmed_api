package med.voll.api.domain.medico;

import jakarta.validation.Valid; //bean validation
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;
public record DatosRegistroMedico( // record es una clase inmutable que se usa para almacenar datos
        @NotBlank(message = "EL nombre es obligatorio")
        String nombre,
        @NotBlank(message = "El e-mail es obligatorio")
        String email,
        @NotBlank(message = "el telefono es obligatorio")
        String telefono,
        @NotBlank(message = "El documento es obligatorio")
        @Pattern(regexp = "\\d{4,6}")
        String documento,
        @NotNull(message = "{epecialidad.obligatorio}") //
        Especialidad especialidad,
        @Valid //valida el objeto direccion
        DatosDireccion direccion){
}
