package com.eoi.CitaTe.services;


import com.eoi.CitaTe.entities.Empresa;
import com.eoi.CitaTe.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpresaPageableService extends  AbstractBusinessServiceSoloEnt<Empresa, Long, EmpresaRepository> {

    protected EmpresaPageableService(EmpresaRepository empresaRepository) {
        super(empresaRepository);
    }
}
