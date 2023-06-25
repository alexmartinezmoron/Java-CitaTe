package com.eoi.CitaTe.services;

import com.eoi.CitaTe.dto.RolDTO;
import com.eoi.CitaTe.entities.Rol;

import com.eoi.CitaTe.repositories.RolRepository;

import com.eoi.CitaTe.services.mapper.RolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolMapperService extends AbstractBusinessService <Rol, Long, RolDTO, RolRepository, RolMapper> {


    public RolMapperService(RolRepository rolRepository, RolMapper mapper) {
        super(rolRepository, mapper);
    }

    @Autowired
    RolRepository rolRepository;

    public void CrearRol(RolDTO rolDTO){

        Rol rol = new Rol();

        rol.setId(rolDTO.getId());
        rol.setNombreRol(rolDTO.getNombreRol());

        rolRepository.save(rol);

    }
}
