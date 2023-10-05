package com.eoi.CitaTe.repositories;

import com.eoi.CitaTe.entities.Empleado;
import com.eoi.CitaTe.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    List<Empleado> findEmpleadoByEmpresa(Empresa empresa);
}