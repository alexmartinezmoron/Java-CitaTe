package es.eoi.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reserva_id")
    private Long id;

    private Cliente cliente;
    private EstadoReserva estadoReserva;

    private LocalDateTime objetoFechaHora = LocalDateTime.now();

    private Disponibilidad disponibilidad;

    private Time horaInicio;
    private Time horaFin;
    private Empresa empresa;

    // CONSTRUCTOR


    public Reserva() {
    }
}
