package com.eoi.CitaTe.dto;

import com.eoi.CitaTe.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RolDTO {

    private Long id;
    private String nombreRol;
//    private Usuario usuario;
}
