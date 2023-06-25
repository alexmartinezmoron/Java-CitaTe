package com.eoi.CitaTe.services.mapper;

import com.eoi.CitaTe.dto.CatalogoDeServicioDTO;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.CatalogoDeServicio;
import com.eoi.CitaTe.entities.Valoracion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.catalog.Catalog;
// 1.- Creamos el Mapper para poder extender los métodos de convertir a entidad y a dto
// 2.- Extendemos Abstract Con los valores de la entidad y el dto
// 3.- Al extender necesitamos un DTO
// 4.- Creamos el DTO
// 5.- Creamos los métodos.

@Service
public class CatalogoDeServiciosMapper extends AbstractServiceMapper <CatalogoDeServicio,CatalogoDeServicioDTO>{

    // Nos traemos el toDto y el toEntity pero
    @Override
    public CatalogoDeServicioDTO toDto(CatalogoDeServicio entidad){
        final CatalogoDeServicioDTO dto = new CatalogoDeServicioDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }
    //Convertir de dto a entidad
    @Override
    public CatalogoDeServicio toEntity(CatalogoDeServicioDTO dto){
        final CatalogoDeServicio entidad = new CatalogoDeServicio();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return entidad;
    }

    public CatalogoDeServiciosMapper() {
    }

}
