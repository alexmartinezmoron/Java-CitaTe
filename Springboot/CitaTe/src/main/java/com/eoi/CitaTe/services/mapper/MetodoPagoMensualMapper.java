package com.eoi.CitaTe.services.mapper;

import com.eoi.CitaTe.dto.MetodoPagoMensualDTO;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.MetodoPagoMensual;
import com.eoi.CitaTe.entities.Valoracion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MetodoPagoMensualMapper extends  AbstractServiceMapper<MetodoPagoMensual, MetodoPagoMensualDTO>{

    @Override
    public MetodoPagoMensualDTO toDto(MetodoPagoMensual entidad){
        final MetodoPagoMensualDTO dto = new MetodoPagoMensualDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }
    //Convertir de dto a entidad
    @Override
    public MetodoPagoMensual toEntity(MetodoPagoMensualDTO dto){
        final MetodoPagoMensual entidad = new MetodoPagoMensual();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return entidad;
    }

    public MetodoPagoMensualMapper() {
    }

}
