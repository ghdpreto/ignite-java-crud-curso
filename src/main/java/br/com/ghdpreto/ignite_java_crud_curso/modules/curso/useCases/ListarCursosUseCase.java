package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghdpreto.ignite_java_crud_curso.entities.CursoEntity;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos.CursoResponseDTO;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.repositories.CursoRepository;

@Service
public class ListarCursosUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoResponseDTO> execute() {

        List<CursoEntity> cursos = this.cursoRepository.findAll();

        List<CursoResponseDTO> listCursos = cursos.stream()
                .map(c -> new CursoResponseDTO(
                        c.getId(),
                        c.getName(),
                        c.getCategory(),
                        c.getActive(),
                        c.getCreated_at(),
                        c.getUpdated_at()))
                .toList();

        return listCursos;

    }
}
