package com.eoi.CitaTe.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class Direccion {

    private String calle;
    private int numero;
    private String provincia;
    private String ciudad;
    private int codigoPostal;
  //  private String urlLocalizacion; // Revisar como conseguimos la url de google maps
}