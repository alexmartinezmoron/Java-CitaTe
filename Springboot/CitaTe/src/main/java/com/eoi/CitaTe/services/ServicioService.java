package com.eoi.CitaTe.services;

import com.eoi.CitaTe.abstraccomponents.GenericServiceConJPA;
import com.eoi.CitaTe.dto.ServicioDTO;
import com.eoi.CitaTe.entities.Servicio;
import com.eoi.CitaTe.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ServicioService extends GenericServiceConJPA<Servicio, Long> {

    @Autowired
    private ServicioRepository servicioRepository;





}
