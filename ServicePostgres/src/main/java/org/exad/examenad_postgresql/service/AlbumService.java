package org.exad.examenad_postgresql.service;

import org.exad.examenad_postgresql.comunication_services.ServicioMongo;
import org.exad.examenad_postgresql.exceptions.IdException;
import org.exad.examenad_postgresql.model.Album;
import org.exad.examenad_postgresql.model.Grupo;
import org.exad.examenad_postgresql.repository.AlbumRepository;
import org.exad.examenad_postgresql.repository.GrupoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final GrupoRepository grupoRepository;
    private final ServicioMongo servicioMongo;

    // Constructor para inyectar dependencias
    public AlbumService(AlbumRepository albumRepository, GrupoRepository grupoRepository, ServicioMongo servicioMongo) {
        this.albumRepository = albumRepository;
        this.grupoRepository = grupoRepository;
        this.servicioMongo = servicioMongo;
    }

    // Método para añadir un álbum
    public void addAlbumService(Album album) {
        Grupo grupo = getGrupo(album); // Obtener el grupo asociado al álbum
        album.setGrupo(grupo); // Asignar el grupo al álbum
        albumRepository.save(album); // Guardar el álbum en el repositorio
    }

    // Método para eliminar un álbum por su ID
    public boolean deleteAlbumByIdService(Integer id) {
        if (!albumRepository.existsById(id)) { // Verificar si el álbum existe
            return false;
        }
        albumRepository.deleteById(id); // Eliminar el álbum del repositorio
        return true;
    }

    // Método para crear un álbum
    public void createAlbumService(Album album) {
        Grupo grupo = getGrupo(album); // Obtener el grupo asociado al álbum
        album.setGrupo(grupo); // Asignar el grupo al álbum
        albumRepository.save(album); // Guardar el álbum en el repositorio

        // Crear un objeto auxiliar para el servicio Mongo
        Integer albumID = album.getId();
        Integer grupoID = grupo.getId();
        Album albumAuxMongoServiceDTO = new Album(
                albumID, grupoID, album.getTitulo(), album.getDataLanzamento(),
                album.getPuntuacion()
        );
        servicioMongo.crearAlbum(albumAuxMongoServiceDTO); // Llamar al servicio Mongo para crear el álbum
    }

    // Método para borrar un álbum por su ID
    public boolean borrarAlbumByIdService(Integer id) {
        if (!albumRepository.existsById(id)) { // Verificar si el álbum existe
            return false;
        }
        albumRepository.deleteById(id); // Eliminar el álbum del repositorio
        servicioMongo.borrarAlbumLlamada(id); // Llamar al servicio Mongo para borrar el álbum
        return true;
    }

    // Método privado para obtener el grupo asociado a un álbum
    private Grupo getGrupo(Album album) {
        Grupo grupo = grupoRepository.findByid(album.getGrupo().getId()); // Buscar el grupo por ID
        if (grupo == null) { // Si el grupo no existe, lanzar una excepción
            throw new IdException("El grupo con el id " + album.getGrupo().getId() + " no existe");
        }
        return grupo; // Devolver el grupo encontrado
    }
}