package com.eoi.CitaTe.services.mapper;


import com.eoi.CitaTe.dto.EmpresaDTO;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.Empresa;
import com.eoi.CitaTe.entities.Valoracion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmpresaMapper extends AbstractServiceMapper <Empresa, EmpresaDTO>{


    // Convertir de entidad a dto

    @Override
    public EmpresaDTO toDto(Empresa entidad){
        final EmpresaDTO dto = new EmpresaDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }
    //Convertir de dto a entidad
    @Override
    public Empresa toEntity(EmpresaDTO dto){
        final Empresa entidad = new Empresa();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return entidad;
    }

    public EmpresaMapper() {
    }
}
