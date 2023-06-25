package com.eoi.CitaTe.services;

import com.eoi.CitaTe.abstraccomponents.GenericServiceConJPA;
import com.eoi.CitaTe.dto.*;
import com.eoi.CitaTe.entities.Disponibilidad;
import com.eoi.CitaTe.entities.Valoracion;
import com.eoi.CitaTe.repositories.DisponibilidadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;

@Service
public class DisponibilidadService extends GenericServiceConJPA<Disponibilidad, Long> {

    @Autowired
    DisponibilidadRepository disponibilidadRepository;

    public void CrarCalendario( Disponibilidad disponibilidad){

        int inicioManiana = Integer.parseInt(disponibilidad.getHoraInicioManiana());

        int finManiana= Integer.parseInt(disponibilidad.getHoraFinManiana());

        int huecos = finManiana - inicioManiana;

        huecos *= 60;

        huecos /= 10;

        Array[] huecosManiana = new Array[huecos];


    }

}