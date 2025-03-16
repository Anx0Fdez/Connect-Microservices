package org.examen.examenad.repository;

import org.examen.examenad.model.Grupo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GrupoRepository extends MongoRepository<Grupo, String> {

    //busqueda de grupo por id
    Grupo findByid(String id);

}

