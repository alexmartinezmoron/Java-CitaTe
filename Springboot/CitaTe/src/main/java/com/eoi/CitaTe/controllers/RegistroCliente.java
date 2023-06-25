package com.eoi.CitaTe.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//h
@Controller
public class RegistroCliente {

    @PostMapping("/registroCliente")
    public String datosCliente(
                               @RequestParam("nombreUsuario") String nombreUsuario,
                               @RequestParam("apellido1") String apellido1,
                               @RequestParam("apellido2") String apellido2,
                               @RequestParam("telefono") String telefono,
                               @RequestParam("emailUsuario") String emailUsuario,
                               @RequestParam("passwordUsuario") String passwordUsuario,
                               @RequestParam("repetirpasswordUsuario") String repetirpasswordUsuario
    ){

        return "/HomePostRegistro.html";
    }
}
