package com.eoi.CitaTe.services.mapper;

import com.eoi.CitaTe.dto.RolDTO;
import com.eoi.CitaTe.entities.Rol;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RolMapper extends AbstractServiceMapper <Rol, RolDTO>{

    @Override
    public RolDTO toDto(Rol entidad){
        final RolDTO dto = new RolDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }
    @Override
    public Rol toEntity(RolDTO dto){
        final Rol entidad = new Rol();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return entidad;
    }

    public RolMapper() {
    }


}
