package com.eoi.CitaTe.controllers;


import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.dto.CambioPswDto;
import com.eoi.CitaTe.dto.ClienteDTO;
import com.eoi.CitaTe.dto.UsuarioDTO;
import com.eoi.CitaTe.dto.UsuarioDTOPsw;
import com.eoi.CitaTe.entities.Email;
import com.eoi.CitaTe.entities.Usuario;
import com.eoi.CitaTe.entities.Valoracion;
import com.eoi.CitaTe.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.eoi.CitaTe.repositories.UsuarioRepository;
import com.eoi.CitaTe.services.EmailService;
import com.eoi.CitaTe.services.UsuarioMapperService;
import com.eoi.CitaTe.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controlador para la entidad Usuario.
 *
 * <p>Esta clase se encarga de manejar las solicitudes relacionadas con la entidad Usuario utilizando la funcionalidad proporcionada por
 * la clase {@link MiControladorGenerico}.</p>
 *
 * <p>Los principales componentes de esta clase son:</p>
 * <ul>
 *     <li>Inversión de control (IoC): La clase extiende MiControladorGenerico y utiliza la funcionalidad proporcionada por ella.
 *     Esto permite que los detalles de implementación sean proporcionados por la clase genérica y facilita la reutilización de código
 *     y la consistencia en la implementación de controladores.</li>
 *     <li>Inyección de dependencias (DI): La clase utiliza inyección de dependencias para obtener el nombre de la entidad gestionada.
 *     El valor de entityName se inyecta utilizando la anotación @Value en la propiedad correspondiente. Esto permite la separación de
 *     responsabilidades y mejora la mantenibilidad y escalabilidad del controlador.</li>
 *     <li>Principio de abstracción: La clase extiende la clase genérica MiControladorGenerico, lo que permite una implementación
 *     común de las operaciones CRUD para la entidad Usuario. Esto facilita la reutilización de código y mejora la consistencia en
 *     la implementación de controladores.</li>
 * </ul>
 *
 * @param <Usuario> El tipo de entidad gestionada por el controlador.
 * @Author Alejandro Teixeira Muñoz
 */
@Controller
@RequestMapping("${url.usuario}")
@RequiredArgsConstructor
public class UsuarioController extends MiControladorGenerico<Usuario> {

    @Value("${url.usuario}")
    private String urlBase;


    private String url = "usuarios";
    private String entityName = "usuario";
    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;
    private final UsuarioMapperService usuarioMapperService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;

    /**
     * Constructor de la clase UsuarioController.
     * Se utiliza para crear una instancia del controlador.
     */


    /**
     * Método de inicialización para establecer el valor de entityName y entityPrefix.
     * El valor de entityName se obtiene de una propiedad configurada en un archivo de propiedades utilizando la anotación @Value.
     * Después de la construcción del objeto UsuarioController, se llama a este método para establecer los valores necesarios.
     *
     * @PostConstruct indica que este método debe ejecutarse después de que se haya construido el objeto UsuarioController.
     * Es una anotación de JSR-250 y se utiliza para realizar tareas de inicialización una vez que todas las dependencias hayan sido inyectadas.
     * En este caso, se utiliza para asegurar que entityName y entityPrefix se establezcan correctamente después de la construcción del objeto.
     * @Author Alejandro Teixeira Muñoz
     */



    @Override
    @GetMapping("/create")
    public String create(Model model) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        ClienteDTO clienteDTO = new ClienteDTO();
        model.addAttribute("usuarioDTO", usuarioDTO);
        model.addAttribute("clienteDTO", clienteDTO);
//        model.addAttribute("url", url);
        model.addAttribute("entityName", entityName);

        return "usuarios/altaUsuario"; // Nombre de la plantilla para mostrar todas las entidades
    }

    @PostMapping(value = {"/alta"})
    public String update(@ModelAttribute UsuarioDTO usuarioDTO,
                         @ModelAttribute ClienteDTO clienteDTO) {
        usuarioService.CrearCliente(usuarioDTO, clienteDTO);

        Email correoConfirmacion = new Email();
        correoConfirmacion.setFrom("notificaciones@agestturnos.es");
        correoConfirmacion.setTo(usuarioDTO.getEmail());
        correoConfirmacion.setSubject("Confirmación de registro");
        correoConfirmacion.setContent("Hola " + usuarioDTO.getEmail() + ", tu registro se ha efectuado correctamente.");

        emailService.sendMail(correoConfirmacion);



        return "registroEmpresa/RegistroEmpresa12";

    }



    // controlador para devolver los usuario paginados


//    @GetMapping("/paginados")
//    public String obtenerUsuariosPaginados(
//            @RequestParam(defaultValue = "0") int numeroPagina,
//            @RequestParam(defaultValue = "10") int tamanoPagina,
//            Model model) {
//        Pageable pageable = PageRequest.of(numeroPagina, tamanoPagina);
//        Page<Usuario> usuarioPage = usuarioRepository.findAll(pageable);
//        model.addAttribute("usuarios", usuarioPage);
//        return "usuarios/usuariosPaginados";
//    }

    @GetMapping("/paginados")
    public String obtenerUsuariosPaginados(
            @RequestParam(defaultValue = "0") int numeroPagina,
            @RequestParam(defaultValue = "7") int tamanoPagina,
            Model model) {
        Pageable pageable = PageRequest.of(numeroPagina, tamanoPagina);
        Page<Usuario> usuarioPage = usuarioRepository.findAll(pageable);

        model.addAttribute("usuarios", usuarioPage);

        // Verificar si hay una página anterior
        if (usuarioPage.hasPrevious()) {
            model.addAttribute("paginaAnterior", numeroPagina - 1);
        }


        // Verificar si hay una página siguiente
        if (usuarioPage.hasNext()) {
            model.addAttribute("siguientePagina", numeroPagina + 1);
        }

        // Agregar pagina de inicio, para utilizar como enlace y poder volver al inicio
        model.addAttribute("Inicio", 0);

        return "usuarios/usuariosPaginados";
    }


// Controlador para enviar email y tokken por correo y poder hacer el /resetpass
    @GetMapping("/hasOlvidadoTuPassword")
    public String hasOlvidadoTuPassword(@RequestParam(value = "email", required = false) String email){

        if (email!= null) {

            Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

            if (usuario.isPresent()) {
                String token = usuario.get().getToken();
                System.out.println("------------------------- --------------"+ email + " token: "  + token);

                Email correoCambioContrasenia = new Email();
                correoCambioContrasenia.setFrom("notificaciones@agestturnos.es");
                correoCambioContrasenia.setTo(email);
                correoCambioContrasenia.setSubject("Cambio de contraseña");
                correoCambioContrasenia.setContent("http://localhost:8080/usuarios/resetpass/" + email +"/" + token);

                emailService.sendMail(correoCambioContrasenia);

            } else {
                email=null;
                return "redirect:/usuarios/hasOlvidadoTuPassword";
            }

            return "usuarios/emailEnviadoParaCambioPass";
        }
        return "usuarios/hasolvidado";
    }


    // Controlador para Reset password o ¿Has olvidado tu contraseña?
    @GetMapping("/resetpass/{email}/{token}")
    public String cambiopass(@PathVariable("email") String email, @PathVariable("token") String token, ModelMap intefrazConPantalla) {
        Optional<Usuario> usuario = usuarioMapperService.getRepo().findByEmailAndTokenAndActivoTrue(email,token );
        System.out.println(email + ":" + token );
        UsuarioDTOPsw usuarioCambioPsw = new UsuarioDTOPsw();

        if (usuario.isPresent()){
            usuarioCambioPsw.setEmail(usuario.get().getEmail());
            usuarioCambioPsw.setPass("******************");
            usuarioCambioPsw.setNewpassword("******************");
            intefrazConPantalla.addAttribute("datos", usuarioCambioPsw);
            return "usuarios/resetearpasswordlogin";
        }else {

            //Mostrar página usuario no existe
            return "usuarios/detallesusuarionoencontrado";
        }
    }

    @PostMapping("/resetpass")
    public String saveListaUsuariuos(@ModelAttribute  UsuarioDTOPsw  dto,
                                     @ModelAttribute UsuarioDTO usuarioDTO, Model model) throws Exception {
        //Si las password no coinciden a la pag de error
        if (dto.getPass().equals(dto.getNewpassword())){
            //Buscamnos el usuario
            Usuario usuario = usuarioMapperService.getRepo().findUsuarioByEmailAndActivoTrue(dto.getEmail());
            //Actualizo la password despues de codificarla
            usuario.setPass(passwordEncoder.encode(dto.getPass()));
            //Guardo el usuario
            Usuario usuarioguarado = usuarioMapperService.guardarEntidadEntidad(usuario);

            Email correoCambioContrasenia = new Email();
            correoCambioContrasenia.setFrom("notificaciones@agestturnos.es");
            correoCambioContrasenia.setTo(usuarioDTO.getEmail());
            correoCambioContrasenia.setSubject("Confirmación de cambio de contraseña");
            correoCambioContrasenia.setContent("Hola " + usuarioDTO.getEmail() + ", tu contraseña se ha cambiado correctamente.");

            emailService.sendMail(correoCambioContrasenia);

            return "redirect:/login";
        }else {

            /// Si las pass no coinciden
            //model.addAttribute("error", true);
            //return "/resetpass";
            return "usuarios/resetearpasswordlogin";

        }
    }


    //Controlador de cambio de password
    @GetMapping("/cambiopass")
    public String vistaCambiopasword(){
        return "usuarios/cambiopass";
    }
    @PostMapping("/cambiopass")
    public String cambioPasswordPst(@ModelAttribute(name = "loginForm" ) CambioPswDto cambioPswDto) throws Exception {
        //Encriptamos las passwords
        String passwordAnt =  passwordEncoder.encode(cambioPswDto.getPasswordant());
        String passwordNueva =  passwordEncoder.encode(cambioPswDto.getPasswordnueva());
        //Comprobamos que existe el usuario por email y passweord
        if (usuarioMapperService.getRepo().repValidarPassword(cambioPswDto.getUsername(), passwordAnt) > 0)
        {
            //Modificicamos la passsword
            Usuario usuario = usuarioMapperService.getRepo().findUsuarioByEmailAndPass(cambioPswDto.getUsername(),
                    passwordAnt );
            usuario.setPass(passwordNueva);
            //Guardamos el usuario
            Usuario usuario1 = usuarioMapperService.guardarEntidadEntidad(usuario);
            return "/login";
        }else {
            return "usuarios/cambiopass";
        }
    }


}

