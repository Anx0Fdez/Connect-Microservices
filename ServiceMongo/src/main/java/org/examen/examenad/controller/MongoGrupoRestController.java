package org.examen.examenad.controller;

import org.examen.examenad.model.Grupo;
import org.examen.examenad.service.MongoGrupoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupo")
public class MongoGrupoRestController {

    // Inyección del servicio de MongoGrupo
    public final MongoGrupoService mongoGrupoService;

    // Constructor para inyectar el servicio
    public MongoGrupoRestController(MongoGrupoService mongoGrupoService) {
        this.mongoGrupoService = mongoGrupoService;
    }

    // Endpoint para crear un nuevo documento de grupo en MongoDB
    @PostMapping("/crear")
    public ResponseEntity<String> crearDocumentoMongo(@RequestBody Grupo grupo) {
        try {
            mongoGrupoService.crearGrupo(grupo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Documento creado correctamente");
    }

    // Endpoint para listar todos los grupos en MongoDB
    @GetMapping("/listar")
    public ResponseEntity<List<Grupo>> listarGruposMongo() {
        try {
            List<Grupo> grupoList = mongoGrupoService.getListGrupo();
            if (grupoList.isEmpty()) {
                return ResponseEntity.badRequest().body(null);
            }
            return ResponseEntity.ok().body(grupoList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Endpoint para listar un grupo por su ID en MongoDB
    @GetMapping("/listar/{id}")
    public ResponseEntity<Grupo> listarGruposMongoByID(@PathVariable String id) {
        try {
            Grupo grupo = mongoGrupoService.getListGrupoById(id);
            if (grupo == null) {
                return ResponseEntity.badRequest().body(null);
            }
            return ResponseEntity.ok().body(grupo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Endpoint para borrar un documento de grupo por su ID en MongoDB
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarDocumentoMongo(@PathVariable String id) {
        try {
            mongoGrupoService.deleteByIdService(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Documento eliminado correctamente");
    }

    // Endpoint para actualizar un documento de grupo por su ID en MongoDB
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarDocumentoMongo(@PathVariable String id, @RequestBody Grupo grupo) {
        try {
            mongoGrupoService.updateByIdService(id, grupo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Documento actualizado correctamente");
    }
}