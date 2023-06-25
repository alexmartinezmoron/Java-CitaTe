package com.eoi.CitaTe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {

    private Long id;
    private LocalDate fechaReserva;
    private String hora_inicio;
    private String hora_fin;

    private Long servicioId;



//    private Valoracion valoracion;
//    private Cliente cliente;
//    private Servicio servicio;
}
