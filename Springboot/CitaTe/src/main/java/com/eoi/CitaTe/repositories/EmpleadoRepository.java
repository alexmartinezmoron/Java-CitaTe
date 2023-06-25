package com.eoi.CitaTe.repositories;

import com.eoi.CitaTe.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}