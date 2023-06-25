package com.eoi.CitaTe.services;

import com.eoi.CitaTe.dto.ServicioDTO;
import com.eoi.CitaTe.entities.Servicio;
import com.eoi.CitaTe.repositories.ServicioRepository;
import com.eoi.CitaTe.services.mapper.ServicioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioMapperService extends AbstractBusinessService <Servicio, Long, ServicioDTO, ServicioRepository, ServicioMapper> {

    public ServicioMapperService (ServicioRepository repo, ServicioMapper servicioMapper){
        super(repo,servicioMapper);



    }



    @Autowired
    ServicioRepository servicioRepository;

    public void CrearServicio(ServicioDTO servicioDTO){

        Servicio servicio = new Servicio();

        servicio.setId(servicio.getId());
        servicio.setTiempo(servicio.getTiempo());
        //servicio.setEmpleados();

        servicioRepository.save(servicio);

    }


}
