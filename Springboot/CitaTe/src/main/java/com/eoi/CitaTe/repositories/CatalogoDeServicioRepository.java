package com.eoi.CitaTe.repositories;

import com.eoi.CitaTe.dto.CatalogoDeServicioDTO;
import com.eoi.CitaTe.entities.CatalogoDeServicio;
import com.eoi.CitaTe.entities.Disponibilidad;
import com.eoi.CitaTe.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogoDeServicioRepository extends JpaRepository<CatalogoDeServicio, Long> {

    List<CatalogoDeServicio> findCatalogoDeServicioByEmpresa(Empresa empresa);


}