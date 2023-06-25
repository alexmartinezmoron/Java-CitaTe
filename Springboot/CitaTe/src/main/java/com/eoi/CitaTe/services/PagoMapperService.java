package com.eoi.CitaTe.services;

import com.eoi.CitaTe.dto.PagoDTO;
import com.eoi.CitaTe.entities.Pago;
import com.eoi.CitaTe.repositories.PagoRepository;
import com.eoi.CitaTe.services.mapper.PagoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoMapperService extends AbstractBusinessService<Pago, Long, PagoDTO, PagoRepository, PagoMapper>{

    public PagoMapperService(PagoRepository pagoRepository, PagoMapper mapper) {
        super(pagoRepository, mapper);
    }

    @Autowired
    PagoRepository pagoRepository;

    public void CrearPago(PagoDTO pagoDTO){

        Pago pago = new Pago();

        pago.setId(pagoDTO.getId());

        pagoRepository.save(pago);

    }

}
