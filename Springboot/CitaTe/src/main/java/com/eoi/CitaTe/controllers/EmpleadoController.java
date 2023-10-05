package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.calendario.DiaDelCalendario;
import com.eoi.CitaTe.calendario.Evento;
import com.eoi.CitaTe.dto.*;
import com.eoi.CitaTe.entities.*;
import com.eoi.CitaTe.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.eoi.CitaTe.security.details.MiUserDetails;
import com.eoi.CitaTe.services.*;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("${url.empleado}")
public class EmpleadoController extends MiControladorGenerico<Empleado> {

    @Value("${url.empleado}")
    private String urlBase;
    private String entityName = "empleados";

    public EmpleadoController(){
        super();
    }
    List<Reserva> reservaListPantalla = new ArrayList<>();
    List<Reserva> reservaListDB = new ArrayList<>();

    @Autowired
    EmpleadoMapperService empleadoMapperService;

    @Autowired
    DisponibilidadService disponibilidadService;

    @Autowired
    DisponibilidadMapperService disponibilidadMapperService;

    @Autowired
    ServicioMapperService servicioMapperService;
    @Autowired
    ReservaMapperService reservaMapperService;
    @Autowired
    UsuarioService usuarioService;

    @PostConstruct
    private void init() {
        super.entityName = urlBase;
        super.url = entityName + "/";
    }

    @Override
    @GetMapping("/all")
    public String getAll(Model model) {
        this.url = entityName + "/";

// O bien mostramos todas todos los elementos como entidades
        // List<Valoracion> entities = service.listAll();

// o tras mucho trabajo tambien podemos mostrar  como dto
        List<EmpleadoDTO> entities = empleadoMapperService.buscarTodos();


        model.addAttribute("entities", entities);
        return url + "all-entities"; // Nombre de la plantilla para mostrar todas las entidades
    }

    @GetMapping("/allbyLogin")
    public String getAllbyLogin(Model model, Authentication authentication) {
        this.url = entityName + "/";
        //Obtenemos el nombre de usuario logueado
        MiUserDetails miUserDetails = (MiUserDetails) authentication.getPrincipal();
        String userEmail = miUserDetails.getEmail();

        // Buscamos al usuario correspondiente al nombre de usuario obtenido anteriormente.
        Usuario user = usuarioService.getByEmail(userEmail);

        // Buscamos la empresa
        Empresa empresa = user.getEmpleado().getEmpresa();

        List<Empleado> entities = empleadoMapperService.getRepo().findEmpleadoByEmpresa(empresa);

        model.addAttribute("entities", entities);
        return url + "all-entities-byEmpresa";
    }
    @Override
    @GetMapping("/create")
    public String create(Model model) {
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        model.addAttribute("empleadoDTO", empleadoDTO);
        model.addAttribute("usuarioDTO", usuarioDTO);
        return url + "entity-details";
    }


    @PostMapping(value = {"/actualizar"})
    public String update(@ModelAttribute EmpleadoDTO empleadoDTO,
                         @ModelAttribute UsuarioDTO usuarioDTO,
                         Authentication authentication) {

        //Obtenemos el nombre de usuario logueado
        MiUserDetails miUserDetails = (MiUserDetails) authentication.getPrincipal();
        String userEmail = miUserDetails.getEmail();
        // Buscamos al usuario correspondiente al nombre de usuario obtenido anteriormente.
        Usuario user = usuarioService.getByEmail(userEmail);
        // Buscamos la empresa
        Empresa empresa = user.getEmpleado().getEmpresa();

        empleadoMapperService.CrearEmpleado2(empleadoDTO,usuarioDTO,empresa);

        return "redirect:/" + url  + "allbyLogin";
    }
    @Override
    @GetMapping("/allporempresa")
    public String getById(@PathVariable Object id, Model model) throws MiEntidadNoEncontradaException {
        this.url = entityName + "/";
        try {
            Empleado entity = service.getById(id);
            model.addAttribute("entity", entity);
            return url + "entity-details"; // Nombre de la plantilla para mostrar los detalles de la entidad
        } catch (MiEntidadNoEncontradaException ex) {
            model.addAttribute("mensaje", "Entidad no encontrada");
            model.addAttribute("error", ex.getMessage());
            return "error/error.html"; // Nombre de la plantilla para mostrar la página de error
        }
    }



    @Override
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Object id) {
        service.delete(id);
        return "redirect:/" + url +  "all";
    }


    @GetMapping("/{id}")
    public String getByIdempre(@PathVariable Object id, Model model) throws MiEntidadNoEncontradaException {
        this.url = entityName + "/";
        try {
            Empleado empleadoDTO = service.getById(id);
            Usuario usuarioDTO = empleadoDTO.getUsuario();
            model.addAttribute("empleadoDTO", empleadoDTO);
            model.addAttribute("usuarioDTO", usuarioDTO);
            return url + "entity-details"; // Nombre de la plantilla para mostrar los detalles de la entidad
        } catch (MiEntidadNoEncontradaException ex) {
            model.addAttribute("mensaje", "Entidad no encontrada");
            model.addAttribute("error", ex.getMessage());
            return "error/error.html"; // Nombre de la plantilla para mostrar la página de error
        }
    }

    //// Detalles del trabajador
//    @GetMapping("/details/{id}")
//    public String details(@PathVariable(value = "id") long id, Model model) {
//
//        Empleado empleado = service.getById(id);
//        model.addAttribute("empleado", empleado);
//        model.addAttribute("servicio", new Servicio());
//        //model.addAttribute("disponibilidad", new Disponibilidad());
//
//        // recorremos el set de disponibilidades del empleado
//        for(Disponibilidad disponibilidad : empleado.getDisponibilidades()) {
//
//            // parseamos los datos de String a int para poder operar
//            int inicioManiana = Integer.parseInt(disponibilidad.getHoraInicioManiana());
//            int finManiana = Integer.parseInt(disponibilidad.getHoraFinManiana());
//            int inicioTarde = Integer.parseInt(disponibilidad.getHoraInicioTarde());
//            int finTarde = Integer.parseInt(disponibilidad.getHoraFinTarde());
//
//            //caculamos la horas de por la mañana las pasamos a minutos y dividimos en huevos de 10 min
//
//            int huecosmaniana = finManiana - inicioManiana;
//            int huecostarde = finTarde - inicioTarde;
//            int huecos = huecosmaniana + huecostarde;
//
//            huecos *= 60;
//            huecos /= 10;
//
//            // Creamos un array con el numero de huecos para ese dia
//            //Array[] totalhHecosDelDia = new Array[huecos];
//        }
//        return "empleados/details";
//    }


    /// con calendario

    @GetMapping("/details/{id}")
    public String details(@PathVariable(value = "id") long id,
                          @RequestParam("year") Optional<Integer> yearOK,
                          @RequestParam("month") Optional<Integer> monthOK,
                          @RequestParam("day") Optional<Integer> dayOK,
                          Model model,
                          Principal principal) {
        //Objeto reserva dto
        ReservaDTO reservaDTO = new ReservaDTO();
        //Inicvializamos las resevnas
        reservaListDB.clear();
        reservaListPantalla.clear();

        Empleado empleado = service.getById(id);

        //generamos una lista con los numeros de dia de la semana que trabaja el empleado
        String[] convertedDLaboArray = empleado.getDisponibilidad().getDiaslaborables().split(";");
        List<Integer> convertedDLaboList = new ArrayList<Integer>();
        for (String number : convertedDLaboArray) {
            convertedDLaboList.add(Integer.parseInt(number.trim()));
        }



        ///////// Calendario ////////////////////////////

        LocalDate fechaActual = LocalDate.now();
        //Recojo los valores de los parametros, o pongo los de la fecha actual por defecto si no vienen rellenos
        Integer numeroColumnas = 7;
        Integer year = yearOK.orElse(fechaActual.getYear());
        Integer month = monthOK.orElse(fechaActual.getMonthValue());
        Integer dayOfMonth = dayOK.orElse(1);



        //Si nos han dado un mes 13, sumamos uno al año y ponemos mes 1
        String strdaymin = "";
        String strdaymax = "";
        if(month == 13)
        {
            year+=1;
            month=1;
            strdaymin = year + "-" +
                    String.format("%02d" , month) + "-01 00:00:00";
            strdaymax = year + "-" +
                    String.format("%02d" , month+1) + "-01 00:00:00";
        }
        if(month==0)
        {
            year-=1;
            month=12;
            strdaymin = year + "-" +
                    String.format("%02d" , month) + "-01 00:00:00";
            strdaymax = (year +1)  + "-" +
                    String.format("%02d" , 1) + "-01 00:00:00";
        }
        else{
            strdaymin = year + "-" +
                    String.format("%02d" , month) + "-01 00:00:00";
            strdaymax = year + "-" +
                    String.format("%02d" , month+1) + "-01 00:00:00";
        }
        //Ya tengo puedo consegui las fechas de inicio y de fin
        //Generamos un


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTimemin = LocalDateTime.parse(strdaymin, formatter);
        LocalDateTime dateTimemax = LocalDateTime.parse(strdaymax, formatter);
        //Ahora puedo buscar las reservas del mes para el empleado llamo al repositorio de reservas
        //para obrener reservaListDB



        //Primero calculo un objeto de fecha de la fecha que obtengo de las variables
        LocalDate fechaCalendario = LocalDate.of(year,month, dayOfMonth);
        //Creo una lista multidimensional / anidada de Strings para tener los dias de la semana
        List<List<DiaDelCalendario>> mesCompleto = new ArrayList<>();
        List<DiaDelCalendario> semana = new ArrayList<>();

        //Creo una variable para saber en qué semana estoy, ya que la primera semana es diferente
        int semanaActual=0;

        //Este bucle se ejecuta 1 vez por dia del mes (28...31...)
        for (int i=1; i<=fechaCalendario.lengthOfMonth(); i++ )
        {
            //Calculo la fecha que está ahora mismo recorriendo el generador de calendarios
            LocalDate fechaEnUso = LocalDate.of(year,month,i);

            // Comprobamos sobre los dias de disponibilidades si el empleado trabaja o no.-------
            // al objeto dia d

            //Si la fecha en uso es Lunes (ordinal==0) o la semana actual es la semana 0 debo
            // crear un nuevo array de semana (lo que viene a ser empezar la semana)
            if(fechaEnUso.getDayOfWeek().ordinal() == 0 || semanaActual == 0)
            {
                //Creo mi array de semana
                semana = new ArrayList<>();
                //Añado la nueva semana al mes
                mesCompleto.add(semana);


                //SI es la primera semana del mes, puedo necesitar añadir huecos en blanco
                if(semanaActual == 0)
                {
                    //Al ser la primera semana del mes,
                    // desde el día 0 (que seria la primera casilla lunes) hasta el día de la semana del día 1 del mes que estamos viendo
                    // Añado casillas en blanco para los días que hay que dejar en blanco
                    for (int j=0;j<fechaEnUso.getDayOfWeek().ordinal(); j++)
                    {
                        DiaDelCalendario diaDelCalendario = new DiaDelCalendario();
                        diaDelCalendario.setFecha(fechaEnUso);
                        diaDelCalendario.setDiaNulo(true);
                        //j va de 0( lunes ) a 6 (domingo) y si el número esta en la lista convertedDLaboList
                        //el empleado trabaja
                        if (convertedDLaboList.contains(j)) {
                            diaDelCalendario.setTrabaja(1);

                        }
                        else {
                            diaDelCalendario.setTrabaja(0);
                        }
                        diaDelCalendario.setDay(fechaEnUso.getDayOfWeek().ordinal());
                        //Nos queda ver la lista de reservas
                        //Comnponemos los eventos para la pantalla
                        for (Reserva reserva : reservaListDB){
                            if (reserva.getDiaMes().equals(fechaEnUso.getDayOfWeek().ordinal())){
                                reservaListPantalla.add(reserva);
                            }
                        }

                        // si j esta dentro de la lista marcamos el campo trabajado a 1 si no se queda a 0
                        mesCompleto.get(semanaActual).add(diaDelCalendario);
                        model.addAttribute(diaDelCalendario);
                    }
                }


                //Actualizo el numero de la semana una vez he rellenado lo necesario en la primera
                semanaActual+=1;
            }
            DiaDelCalendario diaDelCalendario = new DiaDelCalendario();



            diaDelCalendario.setFecha(fechaEnUso);
            /////
            if (convertedDLaboList.contains(fechaEnUso.getDayOfWeek().ordinal())) {
                diaDelCalendario.setTrabaja(1);

            }
            else {
                diaDelCalendario.setTrabaja(0);
            }
            /////
            semana.add(diaDelCalendario);
            model.addAttribute(diaDelCalendario);

        }

        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("emppleadoid", id);
        model.addAttribute("reserva",reservaDTO);
        //datos del empleado
        model.addAttribute("empleado", empleado);
        //queremos una lista de servicios
        model.addAttribute("servicios", empleado.getServicios());



        //Lista de servicios del empleado

        //Paso al html el objeto dias
        model.addAttribute("mesCompleto", mesCompleto);
        model.addAttribute("reservas",reservaListPantalla);




        return "empleados/details";
    }

    @PostMapping("/details/{id}")
    public String reservarServicio(@ModelAttribute(name ="reserva") ReservaDTO
                          reservaDTO, Authentication authentication) {

        //Obtenemos el nombre de usuario logueado
        MiUserDetails miUserDetails = (MiUserDetails) authentication.getPrincipal();
        String userEmail = miUserDetails.getEmail();

        // Buscamos al usuario correspondiente al nombre de usuario obtenido anteriormente.
        Usuario user = usuarioService.getByEmail(userEmail);


        reservaMapperService.CrearReserva2(reservaDTO, user.getCliente());

        System.out.println("---------------------------------jasjdjasdfnjsdfjsaddsfajjnfasdjasdjasd--");
        System.out.println("-----------------------------------" + reservaDTO.getFechaReserva());
        System.out.println("-----------------------------------" + reservaDTO.getServicioId());


        return "registroEmpresa/RegistroEmpresa12";
    }






}
