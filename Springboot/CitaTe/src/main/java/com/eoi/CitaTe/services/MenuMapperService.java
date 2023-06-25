package com.eoi.CitaTe.services;

import com.eoi.CitaTe.dto.MenuDTO;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.Menu;
import com.eoi.CitaTe.entities.Valoracion;
import com.eoi.CitaTe.repositories.MenuRepository;
import com.eoi.CitaTe.repositories.ValoracionRepository;
import com.eoi.CitaTe.services.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuMapperService extends AbstractBusinessService<Menu, Long, MenuDTO, MenuRepository, MenuMapper> {

    public MenuMapperService(MenuRepository repo, MenuMapper mapper) {
        super(repo, mapper);
    }

    @Autowired
    MenuRepository menuRepository;



    public void CrearMenu(MenuDTO menuDTO){

        Menu menu = new Menu();


        menu.setId(menu.getId());
        menu.setUrl(menuDTO.getUrl());
        menu.setDescripcion(menu.getDescripcion());
        menu.setActivo(menuDTO.isActivo());

        menuRepository.save(menu);

    }





}
