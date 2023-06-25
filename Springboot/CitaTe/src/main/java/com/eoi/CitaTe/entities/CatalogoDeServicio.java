package com.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "catalogo_de_servicio")
public class CatalogoDeServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_catalogoDeServicio", nullable = false)
    private Long id;
    private String nombre;
    private  String precio; // cambiar a float
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "id_empresa")
    private Empresa empresa;





}