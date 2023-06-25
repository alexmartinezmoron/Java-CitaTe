package com.eoi.CitaTe.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DireccionDTO {

    private String calle;
    private int numero;
    private String provincia;
    private String ciudad;
    private int codigoPostal;
}
