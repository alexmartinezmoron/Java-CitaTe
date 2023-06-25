package com.eoi.CitaTe.dto;

import com.eoi.CitaTe.entities.Empleado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisponibilidadDTO {

    private Long id;
    private String diaDeLaSemana;
    private String horaInicioManiana;
    private String horaFinManiana;
    private String horaInicioTarde;
    private String horaFinTarde;

    //private Empleado empleado;
}
