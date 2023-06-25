package es.eoi.persistence;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "valoracion")
public class Valoracion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "disponibilidad_id")
    private Long id;

    private Empresa empresa;
    private Cliente cliente;
    private int valoracion;
    private String comentario;

    // CONSTRUCTOR

    public Valoracion() {
    }


}
