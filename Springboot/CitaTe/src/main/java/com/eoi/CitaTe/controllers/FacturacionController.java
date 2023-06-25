package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.dto.DisponibilidadDTO;
import com.eoi.CitaTe.dto.FacturacionDTO;
import com.eoi.CitaTe.entities.Disponibilidad;
import com.eoi.CitaTe.entities.Facturacion;
import com.eoi.CitaTe.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.eoi.CitaTe.services.FacturacionMapperService;
import com.eoi.CitaTe.services.mapper.FacturacionMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("${url.facturacion}")
public class FacturacionController extends MiControladorGenerico<Facturacion> {
    @Value("${url.facturacion}")
    private String urlBase;
    private String entityName = "facturaciones";

    public FacturacionController() {
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = entityName;
        super.url = url;
    }

    @Autowired
    FacturacionMapperService facturacionMapperService;

    @Override
    @GetMapping("/all")
    public String getAll(Model model) {
        this.url = entityName + "/";
        List<FacturacionDTO> entities = facturacionMapperService.buscarTodos();
        model.addAttribute("entities", entities);
        return url + "all-entities";

    }

    @Override
    @GetMapping("/create")
    public String create(Model model) {
        FacturacionDTO entity = new FacturacionDTO();
        model.addAttribute("entity", entity);

        return url + "entity-details";
    }


    @PostMapping(value = {"/actualizar"})
    public String update(@ModelAttribute FacturacionDTO entity) {

        facturacionMapperService.CrearFacturacion(entity);
        return "redirect:/" + url + "all";

    }

    @Override
    @GetMapping("/{id}")
    public String getById(@PathVariable Object id, Model model) throws MiEntidadNoEncontradaException {
        this.url = entityName + "/";
        try {
            Facturacion entity = service.getById(id);
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


}
