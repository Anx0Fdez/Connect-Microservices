package org.exad.examenad_postgresql.comunication_services;

import org.springframework.cloud.openfeign.FeignClient;
import org.exad.examenad_postgresql.model.Album;
import org.exad.examenad_postgresql.model.Grupo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "ServiceMongo", url = ("http://localhost:8081"))
public interface ServicioMongo {


    @PostMapping("/grupo/crear")
    void crearGrupoLlamada(@RequestBody Grupo grupoAuxMongoServiceDTO);


    @DeleteMapping("/grupo/borrar/{id}")
    void borrarGrupoLlamada(@PathVariable Integer id);


    @PostMapping("/album/crear")
    void crearAlbum(@RequestBody Album albumAuxMongoServiceDTO);


    @DeleteMapping("/album/borrar/{id}")
    void borrarAlbumLlamada(@PathVariable Integer id);


}
