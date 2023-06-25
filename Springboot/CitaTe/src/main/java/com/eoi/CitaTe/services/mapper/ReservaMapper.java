package com.eoi.CitaTe.services.mapper;

import com.eoi.CitaTe.dto.DisponibilidadDTO;
import com.eoi.CitaTe.dto.ReservaDTO;
import com.eoi.CitaTe.entities.Disponibilidad;
import com.eoi.CitaTe.entities.Reserva;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ReservaMapper extends AbstractServiceMapper <Reserva, ReservaDTO>{

    @Override
    public ReservaDTO toDto(Reserva entidad){
        final ReservaDTO dto = new ReservaDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }

    @Override
    public Reserva toEntity(ReservaDTO dto){
        final Reserva entidad = new Reserva();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return entidad;
    }

    public ReservaMapper() {
    }
}
