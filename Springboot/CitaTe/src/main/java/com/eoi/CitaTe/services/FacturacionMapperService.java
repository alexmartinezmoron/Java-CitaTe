package com.eoi.CitaTe.services;

import com.eoi.CitaTe.dto.FacturacionDTO;
import com.eoi.CitaTe.entities.Facturacion;
import com.eoi.CitaTe.repositories.FacturacionRepository;

import com.eoi.CitaTe.services.mapper.FacturacionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class FacturacionMapperService extends AbstractBusinessService<Facturacion, Long, FacturacionDTO, FacturacionRepository, FacturacionMapper> {

    public FacturacionMapperService(FacturacionRepository facturacionRepository, FacturacionMapper mapper) {
        super(facturacionRepository, mapper);
    }

    @Autowired
    FacturacionRepository facturacionRepository;

    public void CrearFacturacion(FacturacionDTO facturacionDTO){

        Facturacion facturacion = new Facturacion();

        facturacion.setId(facturacionDTO.getId());
        facturacion.setFecha(LocalDate.now());


//        facturacion.setPago(facturacionDTO.getpago())

        facturacionRepository.save(facturacion);

    }
}
