package es.eoi.persistence;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empleado_id")
    private Long id;

    private String nombreEmpleado;
    private String apellidoEmpleado;

    @ManyToOne(cascade = CascadeType.ALL)
    private Empresa empresa;

    // CONSTRUCTOR


    public Empleado() {
    }


}
