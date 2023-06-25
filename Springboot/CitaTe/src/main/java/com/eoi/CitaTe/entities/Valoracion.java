package com.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "valoracion")
public class Valoracion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_valoracion", nullable = false)
    private Long id;

    private String comentario;

    @Basic(optional = true)
    private boolean activo;

    private int puntuacion;

//    @OneToOne(mappedBy = "valoracion")
//    private Reserva reserva;
}