package com.eoi.CitaTe.services;

import com.eoi.CitaTe.abstraccomponents.GenericServiceConJPA;
import com.eoi.CitaTe.dto.*;
import com.eoi.CitaTe.entities.*;
import com.eoi.CitaTe.repositories.EmpleadoRepository;
import com.eoi.CitaTe.repositories.EmpresaRepository;
import com.eoi.CitaTe.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.eoi.CitaTe.errorcontrol.exceptions.MiEntidadNoEncontradaException;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioService extends GenericServiceConJPA<Usuario, Long> {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder codificadorContraseñas;
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    RolService rolService;


    public Usuario getByUsername(String email) {
                return usuarioRepository.findByEmail(email).orElseThrow(MiEntidadNoEncontradaException::new);
    }

    public Usuario getByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(MiEntidadNoEncontradaException::new);
    }

    public void CrearCliente(UsuarioDTO usuarioDTO, ClienteDTO clienteDTO){
        Usuario usuario = new Usuario();
        Cliente cliente = new Cliente();

        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPass(codificadorContraseñas.encode(usuarioDTO.getPass()));
        usuario.setActivo(true);

        cliente.setNombreCliente(clienteDTO.getNombreCliente());
        cliente.setApellido1Cliente(clienteDTO.getApellido1Cliente());
        cliente.setApellido2Cliente(clienteDTO.getApellido2Cliente());
        cliente.setTelefono(clienteDTO.getTelefono());

        usuario.setCliente(cliente);
        usuario.setRol(rolService.getById(1L));


        usuarioRepository.save(usuario);
    }



    public void CrearEmpresa(UsuarioDTO usuarioDTO, EmpresaDTO empresaDTO, EmpleadoDTO empleadoDTO, DireccionDTO direccionDTO, ContactoDTO contactoDTO){


        Empresa empresa = new Empresa();
        Empleado empleado = new Empleado();
        Usuario usuario = new Usuario();
        Direccion direccion = new Direccion();
        Contacto contacto = new Contacto();


        direccion.setProvincia(direccionDTO.getProvincia());
        direccion.setCodigoPostal(direccionDTO.getCodigoPostal());
        direccion.setNumero(direccionDTO.getNumero());
        direccion.setCiudad(direccionDTO.getCiudad());
        direccion.setCalle(direccionDTO.getCalle());

        contacto.setTelefono1(contactoDTO.getTelefono1());
        contacto.setTelefono2(contactoDTO.getTelefono2());
        contacto.setEmailContacto(contactoDTO.getEmailContacto());



        empresa.setDireccion(direccion);
        empresa.setContacto(contacto);

        empresa.setDescripcionEmpresa(empresaDTO.getDescripcionEmpresa());
        empresa.setNombreEmpresa(empresaDTO.getNombreEmpresa());
        empresa.setCif(empresaDTO.getCif());
        empresa.setLogoEmpresa(empresaDTO.getLogoEmpresa());
        empresa.setTipoNegocio(empresaDTO.getTipoNegocio());


        empresaRepository.save(empresa);

        empleado.setNombreEmpleado(empleadoDTO.getNombreEmpleado());
        empleado.setApellido1Empleado(empleadoDTO.getApellido1Empleado());
        empleado.setApellido2Empleado(empleadoDTO.getApellido2Empleado());

        empleado.setEmpresa(empresa);

        empleadoRepository.save(empleado);


        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPass(codificadorContraseñas.encode(usuarioDTO.getPass()));
        usuario.setActivo(true);
        usuario.setEmpleado(empleado);
         usuario.setEmpleado(empleado);
        //Configuramos para que el empleado que se cree inicialmente sea el feje de la empresa
        usuario.setRol(rolService.getById(3L));
        usuario.setEmpleado(empleado);
        usuarioRepository.save(usuario);


    }

    // Hecho el registro de la empresa como "Propietario" añadimos este método para poder añadir empleados.
    public void CrearEmpleado(UsuarioDTO usuarioDTO, EmpleadoDTO empleadoDTO){

        Empleado empleado = new Empleado();
        Usuario usuario = new Usuario();

        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPass(codificadorContraseñas.encode(usuarioDTO.getPass()));
        usuario.setActivo(true);

        empleado.setNombreEmpleado(empleadoDTO.getNombreEmpleado());
        empleado.setApellido1Empleado(empleadoDTO.getApellido1Empleado());
        empleado.setApellido2Empleado(empleadoDTO.getApellido2Empleado());

        //empleado.setEmpresa(empleadoDTO.getEmpresa());  PREGUNTAR en tutorio

        usuario.setEmpleado(empleado);

        usuario.setRol(rolService.getById(2L));


        usuarioRepository.save(usuario);
    }

}
