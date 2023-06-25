package com.eoi.CitaTe.services.mapper;

import com.eoi.CitaTe.dto.ServicioDTO;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.Servicio;
import com.eoi.CitaTe.entities.Valoracion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ServicioMapper extends AbstractServiceMapper <Servicio, ServicioDTO> {

    @Override
    public ServicioDTO toDto(Servicio entidad){
        final ServicioDTO dto = new ServicioDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }
    //Convertir de dto a entidad
    @Override
    public Servicio toEntity(ServicioDTO dto){
        final Servicio entidad = new Servicio();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return entidad;
    }

    public ServicioMapper() {
    }
}
