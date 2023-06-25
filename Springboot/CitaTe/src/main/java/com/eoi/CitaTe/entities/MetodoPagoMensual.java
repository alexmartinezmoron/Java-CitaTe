package com.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "metodo_pago_mensual")
public class MetodoPagoMensual {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_metodo_pago_mensual", nullable = false)
    private Long id;
    //private Empresa empresa;

}