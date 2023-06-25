package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.dto.FacturacionDTO;
import com.eoi.CitaTe.dto.PagoDTO;
import com.eoi.CitaTe.entities.Facturacion;
import com.eoi.CitaTe.entities.Pago;
import com.eoi.CitaTe.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.eoi.CitaTe.services.FacturacionMapperService;
import com.eoi.CitaTe.services.PagoMapperService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("${url.pago}")

public class PagoController extends MiControladorGenerico<Pago> {
    @Value("${url.pago}")
    private String urlBase;
    private String entityName = "pagos";

    public PagoController() {
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = entityName;
        super.url = url;
    }

    @Autowired
    PagoMapperService pagoMapperService;

    @Override
    @GetMapping("/all")
    public String getAll(Model model) {
        this.url = entityName + "/";
        List<PagoDTO> entities = pagoMapperService.buscarTodos();
        model.addAttribute("entities", entities);
        return url + "all-entities";
    }

    @Override
    @GetMapping("/create")
    public String create(Model model) {
        PagoDTO entity = new PagoDTO();
        model.addAttribute("entity", entity);
        return url + "entity-details";
    }


    @PostMapping(value = {"/actualizar"})
    public String update(@ModelAttribute PagoDTO entity) {
        pagoMapperService.CrearPago(entity);
        return "redirect:/" + url + "all";

    }

    @Override
    @GetMapping("/{id}")
    public String getById(@PathVariable Object id, Model model) throws MiEntidadNoEncontradaException {
        this.url = entityName + "/";
        try {
            Pago entity = service.getById(id);
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