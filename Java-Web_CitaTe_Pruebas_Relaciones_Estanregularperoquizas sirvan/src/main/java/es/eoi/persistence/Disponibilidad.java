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
   @OneToOne(mappedBy = "disponibilidad")
    private Empresa empresa;
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "id_empleado", referencedColumnName = "empleado_id")
    private Empleado empleado;
    private LocalDateTime localDateTime;
    private Time horaInicio;
    private Time horaFin;


// CONSTRUCTOR


    public Disponibilidad() {
    }
}
