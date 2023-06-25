package es.eoi.persistence;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "servicio_id")
    private Long id;

    private String nombre;
    private float precio;
    private String descripcion;
    @ManyToOne(cascade = CascadeType.ALL)
    private  Empresa empresa;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (name = "empleado",
    joinColumns = @JoinColumn(name = "serivicio_id", referencedColumnName = "servicio_id"),
            inverseJoinColumns = @JoinColumn(name = "empleado_id", referencedColumnName = "empleado_id"))
    private Empleado empleado;

    // CONSTRUCTOR


    public Servicio() {
    }


}
