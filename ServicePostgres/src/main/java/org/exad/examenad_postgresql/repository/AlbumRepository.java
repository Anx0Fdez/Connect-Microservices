package org.exad.examenad_postgresql.repository;

import org.exad.examenad_postgresql.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

}
