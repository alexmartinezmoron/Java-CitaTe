package com.eoi.CitaTe.calendario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String nombre;

}

