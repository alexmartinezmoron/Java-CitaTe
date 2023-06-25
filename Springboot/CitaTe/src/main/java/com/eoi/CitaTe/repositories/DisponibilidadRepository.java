package com.eoi.CitaTe.repositories;

import com.eoi.CitaTe.entities.Disponibilidad;
import com.eoi.CitaTe.entities.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, Long> {

    List<Disponibilidad> findDisponibilidadByEmpleado_Id(Long id);


}