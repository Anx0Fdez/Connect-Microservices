package org.examen.examenad.controller;

import org.examen.examenad.model.Album;
import org.examen.examenad.service.MongoAlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class MongoAlbumRestController {

    // Servicio de álbumes
    private final MongoAlbumService mongoAlbumService;

    // Constructor para inyectar el servicio de álbumes
    public MongoAlbumRestController(MongoAlbumService mongoAlbumService) {
        this.mongoAlbumService = mongoAlbumService;
    }

    // Endpoint para crear un nuevo álbum en MongoDB
    @PostMapping("/crear")
    public ResponseEntity<String> crearAlbumController(@RequestBody Album album) {
        try {
            mongoAlbumService.crearAlbum(album);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album creado correctamente");
    }

    // Endpoint para borrar un álbum por su ID en MongoDB
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarAlbumController(@PathVariable String id) {
        try {
            mongoAlbumService.deleteAlbumById(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album borrado correctamente");
    }

    // Endpoint para obtener un álbum por su ID en MongoDB
    @GetMapping("/listar/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable String id) {
        try {
            Album album = mongoAlbumService.getAlbumsById(id);
            if (album == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(album);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Endpoint para listar todos los álbumes en MongoDB
    @GetMapping("/listar")
    public ResponseEntity<List<Album>> getAlbums() {
        try {
            List<Album> albumList = mongoAlbumService.getAllAlbums();
            if (albumList == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(albumList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Endpoint para actualizar un álbum por su ID en MongoDB
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarAlbumByIdController(@PathVariable String id, @RequestBody Album album) {
        try {
            mongoAlbumService.updateAlbumByIdService(id, album);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album actualizado correctamente");
    }
}