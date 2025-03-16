package org.examen.examenad.service;

        import org.examen.examenad.exceptions.IdExcepcion;
        import org.examen.examenad.model.Grupo;
        import org.examen.examenad.repository.GrupoRepository;
        import org.springframework.stereotype.Service;

        import java.util.List;

        @Service
        public class MongoGrupoService {

            public final GrupoRepository grupoRepository;

            public MongoGrupoService(GrupoRepository grupoRepository) {
                this.grupoRepository = grupoRepository;
            }

            // Método para crear un nuevo grupo
            public void crearGrupo(Grupo grupo) {
                grupoRepository.save(grupo);
            }

            // Método para obtener todos los grupos
            public List<Grupo> getListGrupo() {
                List<Grupo> grupos = grupoRepository.findAll();
                if (grupos.isEmpty()) {
                    return null;
                }
                return grupoRepository.findAll();
            }

            // Método para obtener un grupo por su id
            public Grupo getListGrupoById(String id) {
                Grupo grupo = grupoRepository.findByid(id);
                if (grupo == null) {
                    return null;
                }
                return grupoRepository.findByid(id);
            }

            // Método para eliminar un grupo por su id
            public void deleteByIdService(String id) {
                Grupo grupo = grupoRepository.findByid(id);
                if (grupo == null) {
                    throw new IdExcepcion("Este id no existe para borrar un grupo");
                }
                grupoRepository.deleteById(id);
            }

            // Método para actualizar un grupo por su id
            public void updateByIdService(String id, Grupo grupo) {
                Grupo existingGrupo = grupoRepository.findByid(id);
                if (existingGrupo == null) {
                    throw new IdExcepcion("Este id no existe para actualizar un grupo");
                }
                existingGrupo.setNome(grupo.getNome());
                existingGrupo.setXenero(grupo.getXenero());
                existingGrupo.setDataFormacion(grupo.getDataFormacion());
                grupoRepository.save(existingGrupo);
            }
        }