package com.eoi.CitaTe.configuration;

import com.eoi.CitaTe.entities.*;
import com.eoi.CitaTe.repositories.*;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Component
public class ConfiguracionInicial implements ApplicationListener<ContextRefreshedEvent> {
    boolean configuracionRealizada = false;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private DisponibilidadRepository disponibilidadRepository;
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private FacturacionRepository facturacionRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MetodoPagoMensualRepository metodoPagoMensualRepository;
    @Autowired
    private PagoRepository pagoRepository;
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private ServicioRepository servicioRepository;
    @Autowired
    private ValoracionRepository valoracionRepository;
    @Autowired
    private CatalogoDeServicioRepository catalogoDeServicioRepository;
    @Autowired
    private PasswordEncoder codificadorContraseña;


        @Override
        @Profile("local")
        @Transactional
        public void onApplicationEvent(ContextRefreshedEvent event) {


            if (configuracionRealizada)
                return;

            // Empresas///////////////////////////////////////////////////
            Empresa empresa = new Empresa();
            Empresa empresa2 = new Empresa();
            Empresa empresa3 = new Empresa();
            Empresa empresa4 = new Empresa();


            empresa.setCif("B999999999");
            empresa.setNombreEmpresa("Ache");
            empresa.setDireccion(new Direccion("principal",5,"Madrid","Getafe",28001));
            empresa.setDescripcionEmpresa("La mejor peluqueria");
//          empresa.setContacto(new Contacto("612314123","","ayuda@gmail.com"));
            empresaRepository.save(empresa);

            empresa2.setCif("B999999998");
            empresa2.setNombreEmpresa("Imnova");
            empresa2.setDireccion(new Direccion("prudencio",20,"Malaga","Almeria",04010));
            empresa2.setDescripcionEmpresa("La mejor barberia");
//          empresa2.setContacto(new Contacto("612314123","","ayuda@gmail.com"));
            empresaRepository.save(empresa2);

            // Bucle para dar de alta varias empresas

            for (int i = 0; i <12 ; i++) {

                empresa3 = new Empresa();
                empresa3.setCif("B999999" + i + "98");
                empresa3.setNombreEmpresa("Imnova" + i);
                empresa3.setDireccion(new Direccion("prudencio",i,"Almeria","Almeria",04010));
                empresa3.setDescripcionEmpresa("La mejor barberia" + i);
                empresaRepository.save(empresa3);

            }

//            empresa4.setCif("B993339999");
            //           empresa4.setNombreEmpresa("Illo");
            //empresa4.setDireccion(new Direccion("principal",5,"Malaga","Getafe",28001));
            //empresa4.setDescripcionEmpresa("La mejor peluqueria");
//          empresa.setContacto(new Contacto("612314123","","ayuda@gmail.com"));
            //empresaRepository.save(empresa4);

            // Empresas ///////////////////////////////////////////////////

            //// Clientes///////////////////////////////////////////////////

            Cliente cliente = new Cliente();
            cliente.setNombreCliente("Adolfo");
            cliente.setApellido1Cliente("Ramirez");
            cliente.setApellido2Cliente("Rodriguez");
            cliente.setTelefono("633159753");

            Cliente cliente2 = new Cliente();
            cliente.setNombreCliente("Pepe");
            cliente.setApellido1Cliente("Molina");
            cliente.setApellido2Cliente("Rodriguez");
            cliente.setTelefono("631415925");
            //// clientes///////////////////////////////////////////////////

            /// Valoraciones///////////////////////////////////////////////

//            private String comentario;
//
//            private boolean activo;
//
//            private int puntuacion;
//
//            private Reserva reserva;

            Valoracion valoracion = new Valoracion();
            valoracion.setComentario("Mu chala la peluqueria");
            valoracion.setPuntuacion(5);

            Valoracion valoracion2 = new Valoracion();
            valoracion2.setComentario("Mu caro saecio");
            valoracion2.setPuntuacion(1);

            valoracionRepository.save(valoracion);
            valoracionRepository.save(valoracion2);
            /// valoraciones///////////////////////////////////////////////

            /// Catalogo de servicios/////////////////////////////////////

            CatalogoDeServicio catalogoDeServicio = new CatalogoDeServicio();
            catalogoDeServicio.setNombre("Corte");
            catalogoDeServicio.setDescripcion("Corte de pelo corto normal");
            catalogoDeServicio.setPrecio("10");
            catalogoDeServicio.setEmpresa(empresa);


            CatalogoDeServicio catalogoDeServicio2 = new CatalogoDeServicio();
            catalogoDeServicio2.setNombre("Degradado");
            catalogoDeServicio2.setDescripcion("corte de pelo con degrado y peinado");
            catalogoDeServicio2.setPrecio("15");
            catalogoDeServicio2.setEmpresa(empresa);

            CatalogoDeServicio catalogoDeServicio3 = new CatalogoDeServicio();
            catalogoDeServicio3.setNombre("Barba");
            catalogoDeServicio3.setDescripcion("corte de barba o afeitado");
            catalogoDeServicio3.setPrecio("5");
            catalogoDeServicio3.setEmpresa(empresa);

            catalogoDeServicioRepository.save(catalogoDeServicio);
            catalogoDeServicioRepository.save(catalogoDeServicio2);
            catalogoDeServicioRepository.save(catalogoDeServicio3);
            /// catalogo de servicios/////////////////////////////////////

            /// DISPONIBILIDADES///////////////////////////////////////////////
            Disponibilidad disponibilidad = new Disponibilidad();
            Disponibilidad disponibilidad1 = new Disponibilidad();
            Disponibilidad disponibilidad2 = new Disponibilidad();
            Disponibilidad disponibilidad3 = new Disponibilidad();

            disponibilidad.setDiaDeLaSemana(0); // Lunes
            disponibilidad.setHoraInicioManiana("09:00");
            disponibilidad.setHoraFinManiana("14:00");
            disponibilidad.setHoraInicioTarde("17:00");
            disponibilidad.setHoraFinTarde("20:00");
           // disponibilidad.setEmpleado(empleado);
            disponibilidadRepository.save(disponibilidad);

            disponibilidad1.setDiaDeLaSemana(1);  // martes
            disponibilidad1.setHoraInicioManiana("09:00");
            disponibilidad1.setHoraFinManiana("14:00");
            disponibilidad1.setHoraInicioTarde("17:00");
            disponibilidad1.setHoraFinTarde("20:00");
            disponibilidad1.setDiaslaborables("0;2;3");
            disponibilidadRepository.save(disponibilidad1);

            disponibilidad2.setDiaDeLaSemana(0); // Lunes
            disponibilidad2.setHoraInicioManiana("09:00");
            disponibilidad2.setHoraFinManiana("14:00");
            disponibilidad2.setHoraInicioTarde("17:00");
            disponibilidad2.setHoraFinTarde("20:00");
           // disponibilidad2.setEmpleado(empleado2);
            disponibilidadRepository.save(disponibilidad2);

            disponibilidad3.setDiaDeLaSemana(0); // Lunes
            disponibilidad3.setHoraInicioManiana("09:00");
            disponibilidad3.setHoraFinManiana("14:00");
            disponibilidad3.setHoraInicioTarde("17:00");
            disponibilidad3.setHoraFinTarde("20:00");
           // disponibilidad3.setEmpleado(empleado3);
            disponibilidadRepository.save(disponibilidad3);
            /// DISPONIBILIDADES///////////////////////////////////////////////

            // Empleado ///////////////////////////////////////////////////

            Empleado empleado = new Empleado();
            Empleado empleado2 = new Empleado();
            Empleado empleado3 = new Empleado();

            empleado.setNombreEmpleado("Antonio");
            empleado.setApellido1Empleado("Martinez");
            empleado.setApellido2Empleado("Sanchez");
            empleado.setEmpresa(empresa);
            empleado.setDisponibilidad(disponibilidad1);
            empleadoRepository.save(empleado);

            empleado2.setNombreEmpleado("Jose");
            empleado2.setApellido1Empleado("Martinez");
            empleado2.setApellido2Empleado("Muños");
            empleado2.setEmpresa(empresa);
            empleado2.setDisponibilidad(disponibilidad1);
            empleadoRepository.save(empleado2);

            empleado3.setNombreEmpleado("Ana");
            empleado3.setApellido1Empleado("Jimenez");
            empleado3.setApellido2Empleado("Sanchez");
            empleado3.setEmpresa(empresa);
            empleado3.setDisponibilidad(disponibilidad1);
            empleadoRepository.save(empleado3);


            // Empleado ///////////////////////////////////////////////////

             /// ROL  ///////////////////////////////////////////////
             Rol rolCliente = new Rol();
             Rol rolEmpleado = new Rol();
             Rol rolEncargado = new Rol();
             Rol rolJefe = new Rol();
             Rol rolAdmin = new Rol();

             rolCliente.setNombreRol("rolCliente");
             rolEmpleado.setNombreRol("rolEmpleado");
             rolEncargado.setNombreRol("rolEncargado");
             rolJefe.setNombreRol("rolJefe");
             rolAdmin.setNombreRol("rolAdmin");

             rolRepository.save(rolCliente);
             rolRepository.save(rolEmpleado);
             rolRepository.save(rolJefe);
             rolRepository.save(rolAdmin);
            /// ROL  ///////////////////////////////////////////////



            /// Facturación /////

            Facturacion facturacion = new Facturacion();
            facturacion.setFecha(LocalDate.parse("2023-06-14"));
            facturacionRepository.save(facturacion);

            /// Facturación /////

            /// Menu ///
            Menu menu = new Menu();
            menu.setUrl("url en cuestión");
            menu.setDescripcion("Este es el primer menu");
            menu.setActivo(true);
            menuRepository.save(menu);
            /// Menu ///

            /// Reserva //

            Reserva reserva = new Reserva();
            reserva.setEstadoReserva(true);
            reserva.setFechaReserva(LocalDate.parse("2023-06-14"));
            reserva.setHora_inicio("09:00");
            reserva.setHora_fin("12:00");
            reserva.setCliente(cliente);
            reserva.setValoracion(valoracion);
            reservaRepository.save(reserva);

            /// Reserva //

            /// Servicio ///

            Servicio servicio = new Servicio();
            Servicio servicio1 = new Servicio();
            Servicio servicio2 = new Servicio();
            Servicio servicio3 = new Servicio();
            Servicio servicio4 = new Servicio();
            Servicio servicio5 = new Servicio();

            servicio.setTiempo(15);
            servicio.setEmpleado(empleado);
            servicio.setCatalogoDeServicio(catalogoDeServicio);
            servicioRepository.save(servicio);

            servicio1.setTiempo(20);
            servicio1.setEmpleado(empleado);
            servicio1.setCatalogoDeServicio(catalogoDeServicio2);
            servicioRepository.save(servicio1);

            servicio2.setTiempo(5);
            servicio2.setEmpleado(empleado);
            servicio2.setCatalogoDeServicio(catalogoDeServicio3);
            servicioRepository.save(servicio2);

            servicio3.setTiempo(20);
            servicio3.setEmpleado(empleado2);
            servicio3.setCatalogoDeServicio(catalogoDeServicio);
            servicioRepository.save(servicio3);

            servicio4.setTiempo(30);
            servicio4.setEmpleado(empleado2);
            servicio4.setCatalogoDeServicio(catalogoDeServicio2);
            servicioRepository.save(servicio4);

            servicio5.setTiempo(9);
            servicio5.setEmpleado(empleado3);
            servicio5.setCatalogoDeServicio(catalogoDeServicio);
            servicioRepository.save(servicio5);

            /// Servicio ///



            //// Usuarios ////////////////////////////////////////////////

            Usuario usuario = new Usuario();
            usuario.setEmail("cliente@citate.com");
            usuario.setActivo(true);
            usuario.setCliente(cliente);
            usuario.setPass(codificadorContraseña.encode("prueba"));
            usuario.setToken("pepe");
            usuario.setRol(rolCliente);
            usuarioRepository.save(usuario);

            Usuario usuario2 = new Usuario();
            usuario2.setEmail("empleado@citate.com");
            usuario2.setActivo(true);
            usuario2.setEmpleado(empleado);
            usuario2.setPass(codificadorContraseña.encode("prueba"));
            usuario2.setRol(rolEmpleado);
            usuarioRepository.save(usuario2);

            Usuario usuario3 = new Usuario();
            usuario3.setEmail("jefe@citate.com");
            usuario3.setActivo(true);
            usuario3.setEmpleado(empleado2);
            usuario3.setPass(codificadorContraseña.encode("prueba"));
            usuario3.setRol(rolJefe);
            usuarioRepository.save(usuario3);

            Usuario usuario4 = new Usuario();
            usuario4.setEmail("admin@citate.com");
            usuario4.setActivo(true);
            usuario4.setPass(codificadorContraseña.encode("prueba"));
            usuario4.setRol(rolAdmin);
            usuarioRepository.save(usuario4);

//            Usuario usuario5 = new Usuario();
//            usuario.setEmail("antgarramm@gmail.com");
//            usuario.setActivo(true);
//            usuario.setCliente(cliente);
//            usuario.setPass(codificadorContraseña.encode("12345"));
//            usuario.setToken("b2a633f2-ce2a-4c24-89e2-b580403c240f");
//            usuario.setRol(rolCliente);
//            usuarioRepository.save(usuario);



            // Creamos un bucle para añadir un par de usuarios mas y poder comprobar paginacion

            for (int i = 0; i <30 ; i++) {

                usuario2 = new Usuario();

                usuario2.setEmail("empleado" + i + "@citate.com");
                usuario2.setActivo(true);
                usuario2.setPass(codificadorContraseña.encode("prueba"));
                usuario2.setRol(rolEmpleado);
                usuarioRepository.save(usuario2);

            }



            configuracionRealizada = true;
        }
}

