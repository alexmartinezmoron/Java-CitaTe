package com.eoi.CitaTe.services;

import com.eoi.CitaTe.abstraccomponents.GenericServiceConJPA;
import com.eoi.CitaTe.entities.Facturacion;
import com.eoi.CitaTe.repositories.FacturacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FacturacionService extends GenericServiceConJPA<Facturacion, Long> {

    @Autowired
    FacturacionRepository facturacionRepository;
}

