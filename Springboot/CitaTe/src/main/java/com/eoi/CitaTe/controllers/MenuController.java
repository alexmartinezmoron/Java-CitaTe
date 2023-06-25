package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.dto.MenuDTO;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.Menu;
import com.eoi.CitaTe.entities.Valoracion;
import com.eoi.CitaTe.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.eoi.CitaTe.services.MenuMapperService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("${url.menu}")
public class MenuController extends MiControladorGenerico<Menu> {
    @Value("${url.menu}")
    private String urlBase;
    private String entityName = "menus";

    public MenuController() {
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = urlBase;
        super.url = entityName + "/";
    }
    @Autowired
    MenuMapperService menuMapperService;

    @Override
    @GetMapping("/all")
    public String getAll(Model model) {
        this.url = entityName + "/";

        // O bien mostramos todas todos los elementos como entidades
        // List<Valoracion> entities = service.listAll();

        // o tras mucho trabajo tambien podemos mostrar  como dto
        List<MenuDTO> entities = menuMapperService.buscarTodos();

        model.addAttribute("entities", entities);
        return url + "all-entities"; // Nombre de la plantilla para mostrar todas las entidades
    }

    @Override
    @GetMapping("/create")
    public String create(Model model) {
        MenuDTO entity = new MenuDTO();
        model.addAttribute("entity", entity);
        return url + "entity-details";
    }
    @PostMapping(value = {"/actualizar"})
    public String update(@ModelAttribute MenuDTO entity) {
        menuMapperService.CrearMenu(entity);

        return "redirect:/" + url  + "all";

    }


    @Override
    @GetMapping("/{id}")
    public String getById(@PathVariable Object id, Model model) throws MiEntidadNoEncontradaException {
        this.url = entityName + "/";
        try {
            Menu entity = service.getById(id);
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




}
