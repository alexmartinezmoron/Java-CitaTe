package com.eoi.CitaTe.dto;

import com.eoi.CitaTe.entities.Reserva;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValoracionDTO {

    private Long id;

    private String comentario;

    private boolean activo;

    private int puntuacion;

//    private Reserva reserva;
}
