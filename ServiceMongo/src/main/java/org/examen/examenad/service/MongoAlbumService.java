package org.examen.examenad.service;

import org.examen.examenad.exceptions.IdExcepcion;
import org.examen.examenad.model.Album;
import org.examen.examenad.model.Grupo;
import org.examen.examenad.repository.AlbumRepository;
import org.examen.examenad.repository.GrupoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoAlbumService {

    // Atributos de clase
    private final AlbumRepository albumRepository;
    private final GrupoRepository grupoRepository;

    // Constructor de la clase
    public MongoAlbumService(AlbumRepository albumRepository, GrupoRepository grupoRepository) {
        this.albumRepository = albumRepository;
        this.grupoRepository = grupoRepository;
    }

    // Método para crear un nuevo álbum
    public void crearAlbum(Album album) {
        if (!getIdGrupo(album.getGrupo_id())) {
            throw new IdExcepcion("Este id no pertenece a un grupo para ser creado");
        }
        albumRepository.save(album);
    }

    // Método para eliminar un álbum por su id
    public void deleteAlbumById(String id) {
        Album album = albumRepository.findByid(id);
        if (album == null) {
            throw new IdExcepcion("Este id no pertenece a un album para ser borrado");
        }
        albumRepository.deleteById(id);
    }

    // Método para obtener un álbum por su id
    public Album getAlbumsById(String id) {
        Album album = albumRepository.findByid(id);
        if (album == null) {
            return null;
        }
        return albumRepository.findByid(id);
    }

    // Método para obtener todos los álbumes
    public List<Album> getAllAlbums() {
        List<Album> albums = albumRepository.findAll();
        if (albums.isEmpty()) {
            return null;
        }
        return albumRepository.findAll();
    }

    // Método para actualizar un álbum por su id
    public void updateAlbumByIdService(String id, Album album) {
        Album existingAlbum = albumRepository.findByid(id);
        if (existingAlbum != null) {
            existingAlbum.setTitulo(album.getTitulo());
            existingAlbum.setData_lanzamento(album.getData_lanzamento());
            existingAlbum.setPuntuacion(album.getPuntuacion());
            albumRepository.save(existingAlbum);
        } else {
            throw new IdExcepcion("Este id no pertenece a un album");
        }
    }

    // Método privado para verificar si un id de grupo existe
    private boolean getIdGrupo(String id) {
        List<Grupo> grupoList = grupoRepository.findAll();
        for (Grupo grupo : grupoList) {
            if (id.equals(grupo.getId())) {
                return true;
            }
        }
        return false;
    }
}