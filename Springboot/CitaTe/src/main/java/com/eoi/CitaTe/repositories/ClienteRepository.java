package com.eoi.CitaTe.repositories;

import com.eoi.CitaTe.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}