package com.eoi.CitaTe.services;


import com.eoi.CitaTe.dto.UsuarioDTO;
import com.eoi.CitaTe.dto.UsuarioDTOPsw;
import com.eoi.CitaTe.entities.Usuario;
import com.eoi.CitaTe.repositories.UsuarioRepository;
import com.eoi.CitaTe.services.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;


@Service
public class UsuarioMapperService extends AbstractBusinessService<Usuario,Long, UsuarioDTO,
        UsuarioRepository, UsuarioMapper>   {
    //


    //Acceso a los datos de la bbdd
    public UsuarioMapperService(UsuarioRepository repo, UsuarioMapper serviceMapper) {

        super(repo, serviceMapper);
    }
    public UsuarioDTO guardar(UsuarioDTO usuarioDto, String password){
        System.out.println("usuarioDto:" +usuarioDto.getEmail() );
        //Traduzco del dto con datos de entrada a la entidad
        final Usuario entidad = getMapper().toEntity(usuarioDto);
        System.out.println("Entidad:" +entidad.getEmail() );
        entidad.setPass(password);
        System.out.println("Entidad:" +entidad.getPass() );
        //Guardo el la base de datos
        Usuario entidadGuardada =  getRepo().save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return getMapper().toDto(entidadGuardada);
    }
    public UsuarioDTO guardar(UsuarioDTOPsw usuarioDtoPsw){
        System.out.println("usuarioDto:" +usuarioDtoPsw.getEmail() );
        //Traduzco del dto con datos de entrada a la entidad
        final Usuario entidad = getMapper().toEntityPsw(usuarioDtoPsw);
        System.out.println("Entidad:" +entidad.getEmail() );
        //Guardo el la base de datos
        Usuario entidadGuardada =  getRepo().save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return getMapper().toDto(entidadGuardada);
    }
    //Método para guardar una lista de usuarios
    //La entrada es una lista de DTO ( que viene de la pantalla)
    //La respuesta tipo void
    @Override
    public void  guardar(List<UsuarioDTO> lUsuarioDto){
        Iterator<UsuarioDTO> it = lUsuarioDto.iterator();

        // mientras al iterador queda proximo juego
        while(it.hasNext()){
            //Obtenemos la password de a entidad
            //Datos del usuario
            Usuario usuario = getMapper().toEntity(it.next());
            usuario.setPass(getRepo().getReferenceById((long) usuario.getId()).getPass());
            getRepo().save(usuario);
        }
    }


}
