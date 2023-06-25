package com.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pago", nullable = false)
    private Long id;





   // @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "facturacion_id", referencedColumnName = "id_facturacion")
   // private Facturacion facturacion;
//    private Empresa empresa;

}