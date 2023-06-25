package com.eoi.CitaTe.services;

import com.eoi.CitaTe.abstraccomponents.GenericServiceConJPA;
import com.eoi.CitaTe.entities.Disponibilidad;
import com.eoi.CitaTe.entities.Empleado;
import com.eoi.CitaTe.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Set;

@Service
public class EmpleadoService extends GenericServiceConJPA<Empleado, Long> {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public void CrarCalendario(Set<Disponibilidad> disponibilidades){

        for(Disponibilidad disponibilidad : disponibilidades) {
            int inicioManiana = Integer.parseInt(disponibilidad.getHoraInicioManiana());
            int finManiana = Integer.parseInt(disponibilidad.getHoraFinManiana());
            int huecos = finManiana - inicioManiana;

            huecos *= 60;
            huecos /= 10;

            Array[] huecosManiana = new Array[huecos];
        }


    }
}
