package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.consulta.DatosAgendarConsulta;

import java.time.DayOfWeek;

public class HorarioDeFuncionamientoClinica {
    public void validar(DatosAgendarConsulta datos){

        var domingo = DayOfWeek.SUNDAY.equals(datos.fecha().getDayOfWeek());

    }
}
