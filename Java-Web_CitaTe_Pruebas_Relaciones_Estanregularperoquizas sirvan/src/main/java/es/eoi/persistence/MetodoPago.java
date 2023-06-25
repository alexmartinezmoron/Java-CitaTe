package es.eoi.persistence;

import javax.persistence.*;

@Entity
@Table(name = "metodoDePago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "metodo_pago")
    private Long id;


   String paypal;

    // CONSTRUCTOR


    public MetodoPago() {
    }
}
