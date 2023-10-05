package com.eoi.CitaTe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


   ///Esto es un follon porque tiene el retun tiene que ir al modal de login hay que hacerlo con fragments seguramente//
    @GetMapping("/login")
    public String login(Model model)
    {        return "login.html";    }
    @GetMapping("/logout")
    public String logout(Model model)
    {        return "/citaTeP1";    }

    @GetMapping("/")
    public String home(){
        return "home/Home.html";
    }

    @GetMapping("/citaTeP1")
    public String citaTeP1() {
        return "perfil/CitaTeP1.html";
    }

//    @GetMapping("/perfil")
//    public String perfil() {
//        return "perfil/Perfil.html";
//    }

    @GetMapping("/registroEmpresa1")
    public String regEmp1() {
        return "registroEmpresa/registroempresa1.html";
    }

    @GetMapping("/registroEmpresa2")
    public String regEmp2() {
        return "registroEmpresa/RegistroEmpresa2.html";
    }

    @GetMapping("/registroEmpresa3")
    public String regEmp3(){
        return "registroEmpresa/RegistroEmpresa3.html";
    }

    @GetMapping("/registroEmpresa4")
    public String regEmp4(){
        return "registroEmpresa/RegistroEmpresa4.html";
    }

    @GetMapping("/registroEmpresa5")
    public String regEmp5(){
        return "registroEmpresa/RegistroEmpresa5.html";
    }

    @GetMapping("/registroEmpresa6")
    public String regEmp6(){
        return "registroEmpresa/RegistroEmpresa6.html";
    }

    @GetMapping("/registroEmpresa7")
    public String regEmp7(){
        return "registroEmpresa/RegistroEmpresa7.html";
    }

    @GetMapping("/registroEmpresa8")
    public String regEmp8(){
        return "registroEmpresa/RegistroEmpresa8.html";
    }

    @GetMapping("/registroEmpresa9")
    public String regEmp9(){
        return "registroEmpresa/RegistroEmpresa9.html";
    }
    @GetMapping("/registroEmpresa10")
    public String regEmp10(){
        return "registroEmpresa/RegistroEmpresa10.html";
    }
    @GetMapping("/registroEmpresa11")
    public String regEmp11(){
        return "registroEmpresa/RegistroEmpresa11.html";
    }
    @GetMapping("/registroEmpresa12")
    public String regEmp12(){
        return "registroEmpresa/RegistroEmpresa12.html";
    }
    @GetMapping("/homepostregistro")
    public String homepregistro(){
        return "home/HomePostRegistro.html";
    }




}
