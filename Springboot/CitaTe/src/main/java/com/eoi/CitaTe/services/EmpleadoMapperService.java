package com.eoi.CitaTe.services;

import com.eoi.CitaTe.dto.CatalogoDeServicioDTO;
import com.eoi.CitaTe.dto.EmpleadoDTO;
import com.eoi.CitaTe.dto.UsuarioDTO;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.CatalogoDeServicio;
import com.eoi.CitaTe.entities.Empleado;
import com.eoi.CitaTe.entities.Empresa;
import com.eoi.CitaTe.entities.Usuario;
import com.eoi.CitaTe.repositories.EmpleadoRepository;
import com.eoi.CitaTe.repositories.EmpresaRepository;
import com.eoi.CitaTe.repositories.UsuarioRepository;
import com.eoi.CitaTe.services.mapper.EmpleadoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoMapperService extends AbstractBusinessService<Empleado, Long, EmpleadoDTO, EmpleadoRepository, EmpleadoMapper> {
        public EmpleadoMapperService(EmpleadoRepository repo, EmpleadoMapper mapper) {
                super(repo, mapper);
        }

        @Autowired
        EmpleadoRepository empleadoRepository;

        @Autowired
        private PasswordEncoder codificadorContraseñas;
        @Autowired
        RolService rolService;
        @Autowired
        UsuarioRepository usuarioRepository;

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

        public Usuario CrearEmpleado2(EmpleadoDTO empleadoDTO, UsuarioDTO usuarioDTO, Empresa empresa){

                Empleado empleado = new Empleado();
                Usuario usuario = new Usuario();
                usuario.setEmail(usuarioDTO.getEmail());
                usuario.setPass(codificadorContraseñas.encode(usuarioDTO.getPass()));
                usuario.setActivo(true);

                empleado.setNombreEmpleado(empleadoDTO.getNombreEmpleado());
                empleado.setApellido1Empleado(empleadoDTO.getApellido1Empleado());
                empleado.setApellido2Empleado(empleadoDTO.getApellido2Empleado());
                empleado.setId(empleadoDTO.getId());
                empleado.setEmpresa(empresa);


                usuario.setEmpleado(empleado);
                usuario.setRol(rolService.getById(2L));
             return   usuarioRepository.save(usuario);

        }




}
