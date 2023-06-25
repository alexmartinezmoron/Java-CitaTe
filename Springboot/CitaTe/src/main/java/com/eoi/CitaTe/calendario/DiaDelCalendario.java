package com.eoi.CitaTe.calendario;

import com.eoi.CitaTe.entities.Reserva;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiaDelCalendario {

    private boolean diaNulo = false;

    private Integer day;
    private LocalDate fecha;

    private Integer trabaja;

}
