package com.eoi.CitaTe.services.mapper;


import com.eoi.CitaTe.dto.PagoDTO;

import com.eoi.CitaTe.entities.Pago;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PagoMapper extends AbstractServiceMapper <Pago, PagoDTO>{

    @Override
    public PagoDTO toDto(Pago entidad){
        final PagoDTO dto = new PagoDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }

    @Override
    public Pago toEntity(PagoDTO dto){
        final Pago entidad = new Pago();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return entidad;
    }

    public PagoMapper() {
    }



}
