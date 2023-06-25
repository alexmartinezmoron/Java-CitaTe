package com.eoi.CitaTe.dto;

import com.eoi.CitaTe.entities.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatalogoDeServicioDTO {

    private Long id;
    private String nombre;
    private  String precio;
    private String descripcion;
    private Empresa empresa;

}
