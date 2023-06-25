package com.eoi.CitaTe.calendario;

import lombok.Getter;
import lombok.Setter;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
@Getter
@Setter
public class CalendarioController {


    @GetMapping("/calendario")
    public String getCalendario(@RequestParam("year") Optional<Integer> yearOK,
                                @RequestParam("month") Optional<Integer> monthOK,
                                @RequestParam("day") Optional<Integer> dayOK,
                                @RequestParam( "diasLaborables") Optional<String> diasLaborables,
                                Model model,
                                Principal principal)
    {

        LocalDate fechaActual = LocalDate.now();
        //Recojo los valores de los parametros, o pongo los de la fecha actual por defecto si no vienen rellenos
        Integer numeroColumnas = 7;
        Integer year = yearOK.orElse(fechaActual.getYear());
        Integer month = monthOK.orElse(fechaActual.getMonthValue());
        Integer dayOfMonth = dayOK.orElse(1);

        //Si nos han dado un mes 13, sumamos uno al año y ponemos mes 1
        if(month == 13)
        {
            year+=1;
            month=1;
        }
        if(month==0)
        {
            year-=1;
            month=12;
        }

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
                        // si j esta dentro de la lista marcamos el campo trabajado a 1 si no se queda a 0
                        mesCompleto.get(semanaActual).add(diaDelCalendario);
                    }
                }
                //Actualizo el numero de la semana una vez he rellenado lo necesario en la primera
                semanaActual+=1;
            }
            DiaDelCalendario diaDelCalendario = new DiaDelCalendario();
            diaDelCalendario.setFecha(fechaEnUso);

            //Yo aqui creo una lista de eventos, siempre la misma para todos los dias.
            //Aqui cada uno deberia rellenar la lista de eventos del dia segun considere.
            // En el caso de tener el usuario y quere utilizar el principal ,por ejemplo hariamos.
            //User usuario = UserRepository.findByUsername(principal.getName())

//            List<Evento> usuario.getEventos();


            List<Evento> eventos = new ArrayList<>();
            Evento evento1 = new Evento();
            evento1.setFechaInicio(LocalDateTime.of(2023, 5,29,15,50));
            evento1.setNombre("Disponibilidad");
            eventos.add(evento1);


//            diaDelCalendario.setEventos(eventos);
            semana.add(diaDelCalendario);

        }



        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("diasLaborables", diasLaborables);

        //Paso al html el objeto dias
        model.addAttribute("mesCompleto", mesCompleto);
        return "calendario";

    }




}