package com.eoi.CitaTe.security.service;

import com.eoi.CitaTe.entities.Permiso;
import com.eoi.CitaTe.entities.Rol;
import com.eoi.CitaTe.entities.Usuario;
import com.eoi.CitaTe.repositories.UsuarioRepository;
import com.eoi.CitaTe.security.details.MiUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

public class MiUserDetailService  implements UserDetailsService {


    // Instanaciamos el repositorio creado para usuario y lo dejamos autowired para
    // que spring lo gestione
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // llamamos a los detaller de usuario que anteriormente hemos creado

        MiUserDetails userDetails = new MiUserDetails();

        Optional<Usuario> usuarioObtenidoDeLaBD = usuarioRepository.findByEmail(email);

        if (usuarioObtenidoDeLaBD.isPresent()){
            userDetails.setUsername(usuarioObtenidoDeLaBD.get().getEmail());
            userDetails.setPassword(usuarioObtenidoDeLaBD.get().getPass());
            Set<GrantedAuthority> ga = new HashSet<>();
            ga.add(new SimpleGrantedAuthority(usuarioObtenidoDeLaBD.get().getRol().getNombreRol()));
            userDetails.setGrantedAuthorities(ga);

            // Para establecer el nombre del usuario dependera de si es cliente o empleado por lo que configuramos if else

            if(usuarioObtenidoDeLaBD.get().getEmpleado()==null){

                userDetails.setNombreUsuario(usuarioObtenidoDeLaBD.get().getCliente().getNombreCliente());
                userDetails.setApellidoUsuario(usuarioObtenidoDeLaBD.get().getCliente().getApellido1Cliente());
            }else {
                userDetails.setNombreUsuario(usuarioObtenidoDeLaBD.get().getEmpleado().getNombreEmpleado());
                userDetails.setApellidoUsuario(usuarioObtenidoDeLaBD.get().getEmpleado().getApellido1Empleado());
            }




            // faltaria incluir si es empleado o si es  con setGrantedAuthorities(getAuthorities(usuarioObtenidoDeLaBD.get().getRoles()));

            return  userDetails;
        }

        return null;
    }

    ////////// GrantedAuthority con  Roles


    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    private List<String> getPrivileges(Collection<Rol> roles) {

        List<String> privileges = new ArrayList<>();
        List<Permiso> collection = new ArrayList<>();
        for (Rol role : roles) {
            privileges.add(role.getNombreRol());
            collection.addAll(role.getPermisos());
        }
        for (Permiso item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }



    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Rol> roles) {

        return getGrantedAuthorities(getPrivileges(roles));
    }



}
