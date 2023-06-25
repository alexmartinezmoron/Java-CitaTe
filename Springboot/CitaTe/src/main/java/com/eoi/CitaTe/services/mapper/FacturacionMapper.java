package com.eoi.CitaTe.services.mapper;
import com.eoi.CitaTe.dto.FacturacionDTO;
import com.eoi.CitaTe.entities.Facturacion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class FacturacionMapper extends AbstractServiceMapper <Facturacion, FacturacionDTO>{

    @Override
    public FacturacionDTO toDto(Facturacion entidad){
        final FacturacionDTO dto = new FacturacionDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }

    @Override
    public Facturacion toEntity(FacturacionDTO dto){
        final Facturacion entidad = new Facturacion();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return entidad;
    }

    public FacturacionMapper() {
    }
}
