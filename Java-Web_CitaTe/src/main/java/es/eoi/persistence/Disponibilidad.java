package es.eoi.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "disponibilidad")
public class Disponibilidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "disponibilidad_id")
    private Long id;

    private Empresa empresa;
    private Empleado empleado;
    private LocalDateTime localDateTime;
    private Time horaInicio;
    private Time horaFin;


// CONSTRUCTOR


    public Disponibilidad() {
    }
}
