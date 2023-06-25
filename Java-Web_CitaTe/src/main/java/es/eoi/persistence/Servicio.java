package es.eoi.persistence;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "disponibilidad_id")
    private Long id;

    private String nombre;
    private float precio;
    private String descripcion;
    private  Empresa empresa;
    private Empleado empleado;

    // CONSTRUCTOR


    public Servicio() {
    }


}
