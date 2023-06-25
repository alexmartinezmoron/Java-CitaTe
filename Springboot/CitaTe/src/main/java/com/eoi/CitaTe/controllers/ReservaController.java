package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;

import com.eoi.CitaTe.dto.DisponibilidadDTO;
import com.eoi.CitaTe.dto.ReservaDTO;
import com.eoi.CitaTe.entities.*;
import com.eoi.CitaTe.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.eoi.CitaTe.repositories.ReservaRepository;
import com.eoi.CitaTe.services.ReservaMapperService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("${url.reserva}")
public class ReservaController extends MiControladorGenerico<Reserva> {
    @Value("${url.reserva}")
    private String urlBase;
    private String entityName = "reservas";

    public ReservaController() {
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = urlBase;
        super.url = entityName + "/";
    }

    @Autowired
    ReservaMapperService reservaMapperService;

    @Override
    @GetMapping("/all")
    public String getAll(Model model) {
        this.url = entityName + "/";
        List<ReservaDTO> entities = reservaMapperService.buscarTodos();
        model.addAttribute("entities", entities);
        return url + "all-entities";
    }


    @GetMapping("/create/{idempleado}")
    public String createnew(@PathVariable Long idEmpleado,@ModelAttribute(name ="reserva") ReservaDTO reservaDTO,
                            Model model) {
        ReservaDTO entity = new ReservaDTO();
        model.addAttribute("entity", entity);
        return url + "entity-details";
    }
    @PostMapping("/create/{idempleado}")
    public String createnewpost(@PathVariable Long idEmpleado, @ModelAttribute(name ="entity") ReservaDTO reservaDTO) {
        ReservaDTO entity = new ReservaDTO();
        // ahora guardo


        return url + "entity-details";
    }

    @PostMapping(value = {"/actualizar"})
    public String update(@ModelAttribute ReservaDTO entity) {
        reservaMapperService.CrearReserva(entity);
        return "redirect:/" + url + "all";

    }

    @Override
    @GetMapping("/{id}")
    public String getById(@PathVariable Object id, Model model) throws MiEntidadNoEncontradaException {
        this.url = entityName + "/";
        try {
            Reserva entity = service.getById(id);
            model.addAttribute("entity", entity);
            return url + "entity-details";
        } catch (MiEntidadNoEncontradaException ex) {
            model.addAttribute("mensaje", "Entidad no encontrada");
            model.addAttribute("error", ex.getMessage());
            return "error/error.html";
        }
    }

    @Override
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Object id) {
        service.delete(id);
        return "redirect:/" + url + "all";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable(value = "id") long id, Model model) {
        Reserva reserva = service.getById(id);

        model.addAttribute("reserva", reserva);
        model.addAttribute("disponibilidad", new Disponibilidad());

        return "reservas/details";
    }





}
