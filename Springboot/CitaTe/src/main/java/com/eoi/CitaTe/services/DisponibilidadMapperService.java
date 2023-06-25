package com.eoi.CitaTe.services;

import com.eoi.CitaTe.dto.DisponibilidadDTO;
import com.eoi.CitaTe.entities.Disponibilidad;
import com.eoi.CitaTe.repositories.DisponibilidadRepository;
import com.eoi.CitaTe.services.mapper.DisponibilidadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisponibilidadMapperService extends AbstractBusinessService<Disponibilidad, Long, DisponibilidadDTO, DisponibilidadRepository, DisponibilidadMapper>{

    public DisponibilidadMapperService(DisponibilidadRepository disponibilidadRepository, DisponibilidadMapper mapper) {
        super(disponibilidadRepository, mapper);
    }

    @Autowired
    DisponibilidadRepository disponibilidadRepository;

    public void CrearDisponibilidad(DisponibilidadDTO disponibilidadDTO){

        Disponibilidad disponibilidad = new Disponibilidad();

        disponibilidad.setId(disponibilidadDTO.getId());
        disponibilidad.setDiaDeLaSemana(disponibilidad.getDiaDeLaSemana());
        disponibilidad.setHoraInicioManiana(disponibilidadDTO.getHoraInicioManiana());
        disponibilidad.setHoraFinManiana(disponibilidadDTO.getHoraFinManiana());
        disponibilidad.setHoraInicioTarde(disponibilidadDTO.getHoraInicioTarde());
        disponibilidad.setHoraFinTarde(disponibilidadDTO.getHoraFinTarde());

        disponibilidadRepository.save(disponibilidad);

    }


}
