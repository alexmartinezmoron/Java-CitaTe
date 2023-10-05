package com.eoi.CitaTe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nombreCliente;
    private String apellido1Cliente;
    private String apellido2Cliente;
    private String telefono;
    private byte[] icono;

}
