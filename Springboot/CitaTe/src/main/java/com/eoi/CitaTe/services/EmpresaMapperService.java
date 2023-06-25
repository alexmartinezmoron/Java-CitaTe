package com.eoi.CitaTe.services;


import com.eoi.CitaTe.dto.EmpresaDTO;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.Empresa;
import com.eoi.CitaTe.entities.Valoracion;
import com.eoi.CitaTe.repositories.EmpresaRepository;
import com.eoi.CitaTe.repositories.ValoracionRepository;
import com.eoi.CitaTe.services.mapper.EmpresaMapper;
import com.eoi.CitaTe.services.mapper.ValoracionMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class EmpresaMapperService extends AbstractBusinessService<Empresa, Long, EmpresaDTO, EmpresaRepository, EmpresaMapper> {

    public EmpresaMapperService(EmpresaRepository repo, EmpresaMapper serviceMapper) {
        super(repo, serviceMapper);
    }




}
