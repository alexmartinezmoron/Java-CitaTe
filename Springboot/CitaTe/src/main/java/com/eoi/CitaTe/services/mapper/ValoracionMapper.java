package com.eoi.CitaTe.services.mapper;


import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.Valoracion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ValoracionMapper extends AbstractServiceMapper <Valoracion, ValoracionDTO>{


    // Convertir de entidad a dto

    @Override
    public ValoracionDTO toDto(Valoracion entidad){
        final ValoracionDTO dto = new ValoracionDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }
    //Convertir de dto a entidad
    @Override
    public Valoracion toEntity(ValoracionDTO dto){
        final Valoracion entidad = new Valoracion();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return entidad;
    }

    public ValoracionMapper() {
    }
}
