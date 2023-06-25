package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.dto.*;
import com.eoi.CitaTe.entities.*;
import com.eoi.CitaTe.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.eoi.CitaTe.repositories.EmpresaRepository;
import com.eoi.CitaTe.repositories.UsuarioRepository;
import com.eoi.CitaTe.services.*;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("${url.empresa}")
@RequiredArgsConstructor
public class EmpresaController extends MiControladorGenerico<Empresa> {

    @Value("${url.empresa}")
    private String urlBase;
    private String url = "empresas";
    private String entityName = "empresa";

    private final EmpresaRepository empresaRepository;

    @PostConstruct
    private void init() {
        super.entityName = entityName;
        super.url = url;
    }

    @Autowired
    EmpresaMapperService empresaMapperService;

    @Autowired
    EmpresaPageableService empresaPageableService;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/paginadosBusqueda")
    public String getAllEmpresasPagOrdBusq(@RequestParam("page") Optional<Integer> page,
                                           @RequestParam("size") Optional<Integer> size,
                                           @RequestParam(required = false) String keywordnombre,
                                           @RequestParam(required = false) String keywordprovincia,
                                           @RequestParam(defaultValue = "id,asc") String[] sort,
                                           ModelMap model) {
        //Gestion de los datos de ordenación
        String sortField = sort[0];
        String sortDirection = sort[1];

        Sort.Direction direction = sortDirection.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort.Order order = new Sort.Order(direction, sortField);

        //Gestion de los datos de paginas
        Integer pagina = 0;
        if (page.isPresent()) {
            pagina = page.get() -1;
        }
        Integer maxelementos = 5;
        if (size.isPresent()) {
            maxelementos = size.get();
        }

        //generamos el contenedor
        //Objetos genericos de ordenamiento y paginacion
        Pageable pageable = PageRequest.of(pagina, maxelementos, Sort.by(order));
        Page<Empresa> empresaPageable = null;
        //El objeto empresaPageable cambiara de contenido en función de los filtros y/o del orden
        if (keywordnombre == null &&  keywordprovincia == null ) {
            empresaPageable = this.empresaPageableService.buscarTodos(pageable);

        } else if (keywordnombre != null && keywordnombre.length() > 0  ){
            keywordprovincia = null;

            //Necesiso un método que ordene por nombre
            empresaPageable = empresaPageableService.getRepo().findEmpresaByNombreEmpresaContainingIgnoreCase(keywordnombre,pageable);
            model.addAttribute("keywordnombre",keywordnombre);
        }
        else if (keywordprovincia != null && keywordprovincia.length() > 0  ){
            keywordnombre = null;

            //Necesiso un método que ordene por provincia, ojo provincia esta dentro de la clase Embeddable
            empresaPageable = empresaPageableService.getRepo().findEmpresaByDireccionProvinciaContainingIgnoreCase(keywordprovincia,pageable);
            model.addAttribute("keywordprovincia",keywordprovincia);
        }

        model.addAttribute(pageNumbersAttributeKey,dameNumPaginas(empresaPageable));
        model.addAttribute("currentPage", empresaPageable.getNumber() );
        model.addAttribute("pageSize", maxelementos);
        model.addAttribute("lista", empresaPageable);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");

        return "empresa/paginacionOrdenacionBusqueda";
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/paginados")
    public String paginados(Model model,
                            @RequestParam(defaultValue = "0") int numeroPagina,
                            @RequestParam(defaultValue = "5") int tamanoPagina,
                            @RequestParam(value = "Provincia", required = false) String provincia) {
        this.url = entityName + "/";
        // Creamos un pageable con numero de pagina y tamaño
        Pageable pageable = PageRequest.of(numeroPagina, tamanoPagina);

        // Pasamos todos los empresaDTO como una page
        Page<Empresa> entitiesPage = null;

        if (provincia != null){

            entitiesPage = this.empresaPageableService.buscarTodos(pageable);

            //Pasamos dto al model
            model.addAttribute("entities", entitiesPage);

            // Verificar si hay una página anterior
            if (entitiesPage.hasPrevious()) {
                model.addAttribute("paginaAnterior", numeroPagina - 1);
            }
            // Verificar si hay una página siguiente
            if (entitiesPage.hasNext()) {
                model.addAttribute("siguientePagina", numeroPagina + 1);
            }


        }else {

            entitiesPage = empresaPageableService.getRepo().findEmpresaByNombreEmpresaContainingIgnoreCase(provincia,pageable);

            entitiesPage = this.empresaPageableService.buscarTodos(pageable);
                    //Pasamos dto al model
                    model.addAttribute("entities", entitiesPage);

                    // Verificar si hay una página anterior
                    if (entitiesPage.hasPrevious()) {
                        model.addAttribute("paginaAnterior", numeroPagina - 1);
                    }
                    // Verificar si hay una página siguiente
                    if (entitiesPage.hasNext()) {
                        model.addAttribute("siguientePagina", numeroPagina + 1);
                    }
                }

        // Agregar pagina de inicio, para utilizar como enlace y poder volver al inicio
        model.addAttribute("Inicio", 0);

        ///////////// PRUEBAS/////////////////////////////////////

        //provincia = "Todos";

        // Para el filtro
        model.addAttribute("provinciaFiltro", provincia);

        return entityName + "/" + "paginas";

    }



    @Override
    @GetMapping("/all")
    public String getAll(Model model) {
        this.url = entityName + "/";

// O bien mostramos todas todos los elementos como entidades
        // List<Valoracion> entities = service.listAll();

// o tras mucho trabajo tambien podemos mostrar  como dto
        List<EmpresaDTO> entities = empresaMapperService.buscarTodos();

        model.addAttribute("entities", entities);
        return url + "all-entities"; // Nombre de la plantilla para mostrar todas las entidades
    }




    //Enviar los datos al registro de empresa
    @GetMapping("/createEmpresa")
    public String create3(Model model,
                          @ModelAttribute EmpresaDTO empresaDTO,
                          @ModelAttribute UsuarioDTO usuarioDTO,
                          @ModelAttribute EmpleadoDTO empleadoDTO,
                          @ModelAttribute DireccionDTO direccionDTO,
                          @ModelAttribute ContactoDTO contactoDTO){

        model.addAttribute("usuarioDTO", usuarioDTO);
        model.addAttribute("empresaDTO", empresaDTO);
        model.addAttribute("empleadoDTO", empleadoDTO);
        model.addAttribute("direccionDTO", direccionDTO);
        model.addAttribute("contactoDTO", contactoDTO);
//        model.addAttribute("url", url);
        model.addAttribute("entityName", entityName);

        return "registroEmpresa/altaJs"; // Nombre de la plantilla para mostrar todas las entidades
    }


    private final UsuarioService usuarioService;
    private final EmpresaService empresaService;

    // Alta Empresa
    @PostMapping(value = {"/altaEmpresa"})
    public String update(@ModelAttribute UsuarioDTO usuarioDTO,
                         @ModelAttribute EmpresaDTO empresaDTO,
                         @ModelAttribute EmpleadoDTO empleadoDTO,
                         @ModelAttribute DireccionDTO direccionDTO,
                         @ModelAttribute ContactoDTO contactoDTO) {

        usuarioService.CrearEmpresa(usuarioDTO, empresaDTO, empleadoDTO, direccionDTO, contactoDTO);

        return "/registroEmpresa/RegistroEmpresa12";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    //// Detalles de la empresa
    @GetMapping("/details/{id}")
    public String details(@PathVariable(value = "id") long id, Model model) {
        Empresa empresa = service.getById(id);

        model.addAttribute("empresa", empresa);
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("catalogoDeServicio", new CatalogoDeServicio());

        return "empresa/details";
    }





}
