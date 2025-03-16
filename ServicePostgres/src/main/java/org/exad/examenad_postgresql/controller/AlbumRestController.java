package org.exad.examenad_postgresql.controller;

import org.exad.examenad_postgresql.model.Album;
import org.exad.examenad_postgresql.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postgresService/album")
public class AlbumRestController {

    // Variable del servicio de album
    public final AlbumService albumService;

    // Constructor para inyectar dependencias
    public AlbumRestController(AlbumService albumService) {
        this.albumService = albumService;
    }

    // Endpoint para añadir un nuevo álbum
    @PostMapping("/add")
    public ResponseEntity<String> addNewAlbumPostgreSQLController(@RequestBody Album album) {
        try {
            albumService.addAlbumService(album);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album añadido correctamente");
    }

    // Endpoint para eliminar un álbum por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAlbumByIdPostgreSQLController(@PathVariable Integer id) {
        try {
            boolean eliminado = albumService.deleteAlbumByIdService(id);
            if (!eliminado) {
                return ResponseEntity.badRequest().body("Album no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album eliminado correctamente");
    }

    // Endpoint para crear un nuevo álbum (llamada específica)
    @PostMapping("/crear")
    public ResponseEntity<String> createNewAlbumLlamadaPostgreSQLController(@RequestBody Album album) {
        try {
            albumService.createAlbumService(album);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album creado correctamente en llamada");
    }

    // Endpoint para borrar un álbum por su ID (llamada específica)
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarAlbumByIdLlamadaPostgreSQLController(@PathVariable Integer id) {
        try {
            boolean eliminado = albumService.borrarAlbumByIdService(id);
            if (!eliminado) {
                return ResponseEntity.badRequest().body("Album no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album borrado correctamente en llamada");
    }
}