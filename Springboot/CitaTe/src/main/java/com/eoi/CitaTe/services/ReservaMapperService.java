package com.eoi.CitaTe.services;

import com.eoi.CitaTe.dto.ReservaDTO;
import com.eoi.CitaTe.entities.Cliente;
import com.eoi.CitaTe.entities.Reserva;
import com.eoi.CitaTe.repositories.ReservaRepository;
import com.eoi.CitaTe.services.mapper.ReservaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaMapperService extends AbstractBusinessService<Reserva, Long, ReservaDTO, ReservaRepository, ReservaMapper>{

    public ReservaMapperService(ReservaRepository reservaRepository, ReservaMapper mapper) {
        super(reservaRepository, mapper);
    }

    @Autowired
    ReservaRepository reservaRepository;

    public void CrearReserva(ReservaDTO reservaDTO){

        Reserva reserva = new Reserva();


        reserva.setId(reservaDTO.getId());
        //reserva.setEstadoReserva(reservaDTO.isEstadoReserva());
        reserva.setFechaReserva(reservaDTO.getFechaReserva());
        reserva.setHora_fin(reservaDTO.getHora_fin());
        reserva.setHora_inicio(reservaDTO.getHora_inicio());



        reservaRepository.save(reserva);

    }

    public Reserva CrearReserva2(ReservaDTO reservaDTO, Cliente cliente){

        Reserva reserva = new Reserva();

        reserva.setEstadoReserva(true);
        reserva.setFechaReserva(reservaDTO.getFechaReserva());
        reserva.setHora_fin(reservaDTO.getHora_fin());
        reserva.setHora_inicio(reservaDTO.getHora_inicio());
        reserva.setCliente(cliente);

        return reservaRepository.save(reserva);

    }
}
