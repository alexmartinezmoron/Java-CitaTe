package com.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reserva", nullable = false)
    private Long id;
    @Basic(optional = true)
    private boolean estadoReserva;
    private LocalDate fechaReserva;
    private String hora_inicio;
    private String hora_fin;

    private Integer diaMes; // en th es facil preguntar si el dia que tengo conincide con el dia de la reserva
    // revisar gestion de turnos , calendario con eventos.



    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "valoracion_id", referencedColumnName = "id_valoracion")
    private Valoracion valoracion;


    @OneToOne
    private Disponibilidad disponibilidad;   //no hacer fk

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id_cliente")
    private Cliente cliente;


////////////////////////////////////////////////////
    @Transient
    private Servicio servicio;
    ///////////////////////////////////////////

}


