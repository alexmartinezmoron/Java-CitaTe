package com.eoi.CitaTe.services.mapper;
import com.eoi.CitaTe.dto.DisponibilidadDTO;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.Disponibilidad;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DisponibilidadMapper extends AbstractServiceMapper <Disponibilidad, DisponibilidadDTO>{
    @Override
    public DisponibilidadDTO toDto(Disponibilidad entidad){
        final DisponibilidadDTO dto = new DisponibilidadDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }

    @Override
    public Disponibilidad toEntity(DisponibilidadDTO dto){
        final Disponibilidad entidad = new Disponibilidad();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return entidad;
    }

    public DisponibilidadMapper() {
    }

}
