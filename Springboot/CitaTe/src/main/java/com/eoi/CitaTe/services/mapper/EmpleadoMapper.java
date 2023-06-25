package com.eoi.CitaTe.services.mapper;

import com.eoi.CitaTe.dto.EmpleadoDTO;
import com.eoi.CitaTe.entities.Cliente;
import com.eoi.CitaTe.entities.Empleado;
import com.eoi.CitaTe.repositories.EmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoMapper extends AbstractServiceMapper<Empleado, EmpleadoDTO> {

    @Override
    public EmpleadoDTO toDto(Empleado entidad){
        final EmpleadoDTO dto = new EmpleadoDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }
    //Convertir de dto a entidad
    public Empleado toEntity(EmpleadoDTO dto){
        final Empleado entidad = new Empleado();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return entidad;
    }

    public EmpleadoMapper() {
    }
}
