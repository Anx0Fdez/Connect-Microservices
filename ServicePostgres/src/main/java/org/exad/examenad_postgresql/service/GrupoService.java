package org.exad.examenad_postgresql.service;

import org.exad.examenad_postgresql.comunication_services.ServicioMongo;
import org.exad.examenad_postgresql.model.Grupo;
import org.exad.examenad_postgresql.repository.GrupoRepository;
import org.springframework.stereotype.Service;

@Service
public class GrupoService {

    // Variable del repositorio de Grupo
    private final GrupoRepository grupoRepository;
    // Servicio para comunicación con MongoDB
    private final ServicioMongo servicioMongo;

    // Constructor para inyectar dependencias
    public GrupoService(GrupoRepository grupoRepository, ServicioMongo servicioMongo) {
        this.grupoRepository = grupoRepository;
        this.servicioMongo = servicioMongo;
    }

    // Método para añadir un grupo
    public void addGrupoService(Grupo grupo) {
        grupoRepository.save(grupo);
    }

    // Método para eliminar un grupo por su ID
    public boolean deleteGrupoByIdService(Integer id) {
        if (!grupoRepository.existsById(id)) {
            return false;
        }
        grupoRepository.deleteById(id);
        return true;
    }

    // Método para crear un grupo y sincronizar con MongoDB
    public void createGrupoService(Grupo grupo) {
        grupoRepository.save(grupo);

        // Obtener el ID generado y crear un DTO para MongoDB
        Integer idGenerado = grupo.getId();
        Grupo grupoAuxMongoServiceDTO = new Grupo(idGenerado, grupo.getNome(),
                grupo.getXenero(), grupo.getDataFormacion());
        // Llamada al servicio de MongoDB para crear el grupo
        servicioMongo.crearGrupoLlamada(grupoAuxMongoServiceDTO);
    }

    // Método para borrar un grupo por su ID y sincronizar con MongoDB
    public boolean borrarGrupoByIdService(Integer id) {
        if (!grupoRepository.existsById(id)) {
            return false;
        }
        grupoRepository.deleteById(id);
        // Llamada al servicio de MongoDB para borrar el grupo
        servicioMongo.borrarGrupoLlamada(id);
        return true;
    }
}