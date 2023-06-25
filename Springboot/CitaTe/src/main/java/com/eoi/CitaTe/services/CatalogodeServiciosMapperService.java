package com.eoi.CitaTe.services;


import com.eoi.CitaTe.dto.CatalogoDeServicioDTO;
import com.eoi.CitaTe.dto.ReservaDTO;
import com.eoi.CitaTe.entities.CatalogoDeServicio;
import com.eoi.CitaTe.entities.Cliente;
import com.eoi.CitaTe.entities.Empresa;
import com.eoi.CitaTe.entities.Reserva;
import com.eoi.CitaTe.repositories.CatalogoDeServicioRepository;
import com.eoi.CitaTe.services.mapper.CatalogoDeServiciosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogodeServiciosMapperService extends AbstractBusinessService<CatalogoDeServicio, Long, CatalogoDeServicioDTO,CatalogoDeServicioRepository,CatalogoDeServiciosMapper> {

    public CatalogodeServiciosMapperService(CatalogoDeServicioRepository repo, CatalogoDeServiciosMapper serviciosMapper){
    super(repo,serviciosMapper);
    }


    @Autowired
    CatalogoDeServicioRepository catalogoDeServicioRepository;



    public void CrearCatalagoDeServicio(CatalogoDeServicioDTO catalogoDeServicioDTO){

        CatalogoDeServicio catalogoDeServicio = new CatalogoDeServicio();

        catalogoDeServicio.setNombre(catalogoDeServicioDTO.getNombre());
        catalogoDeServicio.setPrecio(catalogoDeServicioDTO.getPrecio());
        catalogoDeServicio.setDescripcion(catalogoDeServicioDTO.getDescripcion());
        catalogoDeServicio.setId(catalogoDeServicioDTO.getId());
        //catalogoDeServicio.setEmpresa();
        catalogoDeServicioRepository.save(catalogoDeServicio);

    }

    public CatalogoDeServicio CrearCatalagoDeServicio2(CatalogoDeServicioDTO catalogoDeServicioDTO, Empresa empresa){

        CatalogoDeServicio catalogoDeServicio = new CatalogoDeServicio();

        catalogoDeServicio.setNombre(catalogoDeServicioDTO.getNombre());
        catalogoDeServicio.setPrecio(catalogoDeServicioDTO.getPrecio());
        catalogoDeServicio.setDescripcion(catalogoDeServicioDTO.getDescripcion());
        catalogoDeServicio.setId(catalogoDeServicioDTO.getId());
        catalogoDeServicio.setEmpresa(empresa);

        return catalogoDeServicioRepository.save(catalogoDeServicio);

    }
}
