package com.eoi.CitaTe.services.mapper;

import com.eoi.CitaTe.dto.MenuDTO;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.Menu;
import com.eoi.CitaTe.entities.Valoracion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MenuMapper extends AbstractServiceMapper <Menu, MenuDTO> {


    @Override
    public MenuDTO toDto(Menu entidad){
        final MenuDTO dto = new MenuDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }
    //Convertir de dto a entidad
    @Override
    public Menu toEntity(MenuDTO dto){
        final Menu entidad = new Menu();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return entidad;
    }

    public MenuMapper() {
    }








}
