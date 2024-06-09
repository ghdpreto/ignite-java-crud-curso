package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.useCases;

import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghdpreto.ignite_java_crud_curso.entities.CursoEntity;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos.AtualizarCursoDTO;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.exceptions.CursoNotFoundException;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.repositories.CursoRepository;

@Service
public class AtualizarCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(AtualizarCursoDTO atualizarCursoDTO, UUID id) {

        CursoEntity curso = this.cursoRepository.findById(id)
                .orElseThrow(() -> {
                    throw new CursoNotFoundException();
                });

        if (Objects.nonNull(atualizarCursoDTO.category())) {
            curso.setCategory(atualizarCursoDTO.category());
        }

        if (Objects.nonNull(atualizarCursoDTO.name())) {
            curso.setName(atualizarCursoDTO.name());
        }

        return this.cursoRepository.save(curso);
    }
}
