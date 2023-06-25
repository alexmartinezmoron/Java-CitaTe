package com.eoi.CitaTe.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO1 {
    private Long id;
    private String email;
    private String pass;
    private boolean activo;

    String tipoAlta;
    private ClienteDTO clienteDTO;

    private EmpleadoDTO empleadoDTO;


}
