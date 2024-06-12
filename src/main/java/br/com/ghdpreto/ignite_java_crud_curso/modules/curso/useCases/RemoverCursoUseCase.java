package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghdpreto.ignite_java_crud_curso.entities.CursoEntity;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.exceptions.CursoNotFoundException;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.repositories.CursoRepository;

@Service
public class RemoverCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public void execute(UUID id) {

        CursoEntity curso = this.cursoRepository.findById(id).orElseThrow(() -> {
            throw new CursoNotFoundException();
        });

        this.cursoRepository.delete(curso);
    }
}
