package com.eoi.CitaTe.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTOPsw {

    private long id;

    private String email;

    private String pass;

    private String newpassword;


}
