package com.eoi.CitaTe.dto;

import com.eoi.CitaTe.entities.Empleado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicioDTO {



    private Long id;
    private int tiempo;

    // private Set<Empleado> empleados = new HashSet<>();


}
