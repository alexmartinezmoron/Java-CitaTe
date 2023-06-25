package com.eoi.CitaTe.repositories;

import com.eoi.CitaTe.entities.Facturacion;
import com.eoi.CitaTe.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacturacionRepository extends JpaRepository<Facturacion, Long> {
}