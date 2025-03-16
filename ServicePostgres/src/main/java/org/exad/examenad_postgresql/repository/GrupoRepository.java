package org.exad.examenad_postgresql.repository;

import org.exad.examenad_postgresql.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
    Grupo findByid(Integer id);
}
