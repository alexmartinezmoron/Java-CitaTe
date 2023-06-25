package com.eoi.CitaTe.repositories;

import com.eoi.CitaTe.entities.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {


    Page<Empresa> findEmpresaByNombreEmpresaContainingIgnoreCase(String keywordciudad, Pageable pageable);

    Page<Empresa> findEmpresaByCifContainingIgnoreCase(String keywordcif, Pageable pageable);

    Page<Empresa> findEmpresaByDireccionProvinciaContainingIgnoreCase(String keywordprovincia, Pageable pageable);
}