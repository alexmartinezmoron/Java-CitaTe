package com.eoi.CitaTe.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class Contacto {

    private String telefono1;
    private String telefono2;
    private String emailContacto;
}