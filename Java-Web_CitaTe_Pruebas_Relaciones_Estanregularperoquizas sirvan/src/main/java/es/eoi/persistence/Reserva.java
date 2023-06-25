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

    @OneToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id_cliente")
    private Cliente cliente;
    private EstadoReserva estadoReserva;

    private LocalDateTime objetoFechaHora = LocalDateTime.now();

    private Disponibilidad disponibilidad;

    private Time horaInicio;
    private Time horaFin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="id_empresa", referencedColumnName = "empresa_id")
    private Empresa empresa;

    // CONSTRUCTOR


    public Reserva() {
    }
}
