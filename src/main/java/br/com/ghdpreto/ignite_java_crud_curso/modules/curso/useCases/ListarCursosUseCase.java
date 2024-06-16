package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghdpreto.ignite_java_crud_curso.entities.CursoEntity;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.repositories.CursoRepository;

@Service
public class ListarCursosUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoEntity> execute() {

        List<CursoEntity> cursos = this.cursoRepository.findAll();
        return cursos;

    }
}
