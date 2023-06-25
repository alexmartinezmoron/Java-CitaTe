package es.eoi.persistence;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cliente_id")
    private Long id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String icono;
    private Usuario usuario;




    // CONSTRUCTOR

    public Cliente() {
    }


}
