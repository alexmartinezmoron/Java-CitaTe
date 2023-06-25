package com.eoi.CitaTe.services;
import com.eoi.CitaTe.abstraccomponents.GenericServiceConJPA;
import com.eoi.CitaTe.dto.ClienteDTO;
import com.eoi.CitaTe.dto.EmpresaDTO;
import com.eoi.CitaTe.dto.UsuarioDTO;
import com.eoi.CitaTe.entities.Empresa;
import com.eoi.CitaTe.repositories.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpresaService extends GenericServiceConJPA<Empresa, Long> {


    @Autowired
    private EmpresaRepository empresaRepository;

    Empresa empresa = new Empresa();

    public void añadirDescripcion(EmpresaDTO empresaDTO){

        empresa.setDescripcionEmpresa(empresaDTO.getDescripcionEmpresa());

        empresaRepository.save(empresa);

    }

    public void añadirCif (EmpresaDTO empresaDTO){
        empresa.setCif(empresaDTO.getCif());
        empresaRepository.save(empresa);
    }



}
