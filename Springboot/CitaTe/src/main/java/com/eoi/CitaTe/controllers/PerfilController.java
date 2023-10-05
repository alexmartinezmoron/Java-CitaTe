package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.dto.PagoDTO;
import com.eoi.CitaTe.entities.Pago;
import com.eoi.CitaTe.entities.Usuario;
import com.eoi.CitaTe.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.eoi.CitaTe.security.details.MiUserDetails;
import com.eoi.CitaTe.services.PagoMapperService;
import com.eoi.CitaTe.services.UsuarioService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Controller
@RequestMapping("${url.perfil}")

public class PerfilController{

    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/mostrarFotoPerfil")
    @ResponseBody
    public byte[] mostrarImagen(Authentication authentication) throws IOException {


        //Obtenemos el nombre de usuario logueado
        MiUserDetails miUserDetails = (MiUserDetails) authentication.getPrincipal();
        String userEmail = miUserDetails.getEmail();

        // Buscamos al usuario correspondiente al nombre de usuario obtenido anteriormente.

        Usuario user = usuarioService.getByEmail(userEmail);


        // Ruta al directorio donde se almacenan las imágenes
        String rutaImagen = "uploads/" + user.getId() + "/1.jpg"; // Ruta completa al archivo

        File imagen = new File(rutaImagen);
        return Files.readAllBytes(imagen.toPath());
    }
}