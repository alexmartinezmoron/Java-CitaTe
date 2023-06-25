package es.eoi.persistence;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empresa_id")
    private Long id;

    private String nombreEmpresa;
    private String cif;
    @Embedded
    private Direccion direccion;
    private String descripcionEmpresa;
    private String telefono;
    private Usuario usuario;


    ////// Revisar como conseguimos la url de google maps////////////////////
    private String urlLocalizacion;
    private String logo;
    private String caracteristicasEmpresa;

    private MetodoPago metodoPago;
    private String TipoDeNegocio;








// CONSTRUCTOR

    public Empresa() {
    }
}
