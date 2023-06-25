package com.eoi.CitaTe.services;

import com.eoi.CitaTe.dto.MetodoPagoMensualDTO;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.MetodoPagoMensual;
import com.eoi.CitaTe.entities.Valoracion;
import com.eoi.CitaTe.repositories.MenuRepository;
import com.eoi.CitaTe.repositories.MetodoPagoMensualRepository;
import com.eoi.CitaTe.services.mapper.MetodoPagoMensualMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetodoPagoMensualMapperService extends AbstractBusinessService<MetodoPagoMensual, Long, MetodoPagoMensualDTO, MetodoPagoMensualRepository, MetodoPagoMensualMapper> {

    public MetodoPagoMensualMapperService(MetodoPagoMensualRepository repo, MetodoPagoMensualMapper mapper) {
        super(repo, mapper);
    }
    @Autowired
    MetodoPagoMensualRepository metodoPagoMensualRepository;

    public void CrearMetodoPagoMensual(MetodoPagoMensualDTO metodoPagoMensualDTO){


        MetodoPagoMensual metodoPagoMensual = new MetodoPagoMensual();

        metodoPagoMensual.setId(metodoPagoMensualDTO.getId());

        metodoPagoMensualRepository.save(metodoPagoMensual);

    }
}
