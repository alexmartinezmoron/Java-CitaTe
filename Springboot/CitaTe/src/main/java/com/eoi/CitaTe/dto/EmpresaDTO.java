package com.eoi.CitaTe.dto;

import com.eoi.CitaTe.entities.CatalogoDeServicio;
import com.eoi.CitaTe.entities.Contacto;
import com.eoi.CitaTe.entities.Direccion;
import com.eoi.CitaTe.entities.Empleado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDTO {


    private Long id;
    private String nombreEmpresa;
    private String cif;
    private Direccion direccion;



    private String descripcionEmpresa;
    //private Contacto contacto;
    private byte[] logoEmpresa;
    private Set<Empleado> empleados = new HashSet<>();
    private CatalogoDeServicio catalogoDeServicio;



    private ArrayList<String> tipoNegocio = new ArrayList<>();


//    private Set<String> tipoEmpresa = new HashSet; ---> DUDA.
//    private MetodoPagoMensual metodoPagoMensual;
//    private Pago pago;
}
