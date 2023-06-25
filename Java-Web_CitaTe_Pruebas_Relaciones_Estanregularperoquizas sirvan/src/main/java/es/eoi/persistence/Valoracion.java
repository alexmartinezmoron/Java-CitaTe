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
    @ManyToOne(cascade = CascadeType.ALL)
    private Empresa empresa;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
    private Cliente cliente;
    private int valoracion;
    private String comentario;

    // CONSTRUCTOR

    public Valoracion() {
    }


}
