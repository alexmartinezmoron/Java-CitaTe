package com.eoi.CitaTe.services;

import com.eoi.CitaTe.dto.EmpleadoDTO;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.Empleado;
import com.eoi.CitaTe.repositories.EmpleadoRepository;
import com.eoi.CitaTe.services.mapper.EmpleadoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoMapperService extends AbstractBusinessService<Empleado, Long, EmpleadoDTO, EmpleadoRepository, EmpleadoMapper> {
        public EmpleadoMapperService(EmpleadoRepository repo, EmpleadoMapper mapper) {
                super(repo, mapper);
        }

        @Autowired
        EmpleadoRepository empleadoRepository;

        public void CrearEmpleado (EmpleadoDTO empleadoDTO ){
                Empleado empleado = new Empleado();

                empleado.setNombreEmpleado(empleadoDTO.getNombreEmpleado());
                empleado.setApellido1Empleado(empleadoDTO.getApellido1Empleado());
                empleado.setApellido2Empleado(empleadoDTO.getApellido2Empleado());
                empleado.setId(empleadoDTO.getId());
                //empleado.setEmpresa();
                //empleado.setUsuario();
                //empleado.setServicios();
                //empleado.setDisponibilidad();

                empleadoRepository.save(empleado);


        }


}
