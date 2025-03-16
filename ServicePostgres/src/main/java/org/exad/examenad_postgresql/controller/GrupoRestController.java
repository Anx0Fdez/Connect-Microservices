package org.exad.examenad_postgresql.controller;

import org.exad.examenad_postgresql.model.Grupo;
import org.exad.examenad_postgresql.service.GrupoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postgresService/grupo")
public class GrupoRestController {

    // Variable del servicio de grupos
    private final GrupoService grupoService;

    /**
     * Constructor de la clase
     * @param grupoService el servicio de grupos
     */
    public GrupoRestController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    // Endpoint para añadir un nuevo grupo
    @PostMapping("/add")
    public ResponseEntity<String> addNewGrupoPostgreSQLController(@RequestBody Grupo grupo) {
        try {
            grupoService.addGrupoService(grupo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Grupo añadido correctamente");
    }

    // Endpoint para eliminar un grupo por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGrupoByIdPostgreSQLController(@PathVariable Integer id) {
        try {
            boolean eliminado = grupoService.deleteGrupoByIdService(id);
            if (!eliminado) {
                return ResponseEntity.badRequest().body("Grupo no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Grupo eliminado correctamente");
    }

    // Endpoint para crear un nuevo grupo y sincronizar con MongoDB
    @PostMapping("/crear")
    public ResponseEntity<String> createGrupoLlmadaPostgreSQLController(@RequestBody Grupo grupo) {
        try {
            grupoService.createGrupoService(grupo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Grupo creado correctamente en llamada");
    }

    // Endpoint para borrar un grupo por su ID y sincronizar con MongoDB
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarGrupoByIdLlamadaPostgreSQLController(@PathVariable Integer id) {
        try {
            boolean eliminado = grupoService.borrarGrupoByIdService(id);
            if (!eliminado) {
                return ResponseEntity.badRequest().body("Grupo no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Grupo borrado correctamente en llamada");
    }
}