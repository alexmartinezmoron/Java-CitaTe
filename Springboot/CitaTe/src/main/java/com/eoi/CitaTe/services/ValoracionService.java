package com.eoi.CitaTe.services;

import com.eoi.CitaTe.abstraccomponents.GenericServiceConJPA;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.Valoracion;
import com.eoi.CitaTe.repositories.ValoracionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValoracionService extends GenericServiceConJPA<Valoracion, Long> {

    @Autowired
    ValoracionRepository valoracionRepository;

    // Convertir de entidad a dto
    public ValoracionDTO toDto(Valoracion entidad){
        final ValoracionDTO dto = new ValoracionDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }
}
