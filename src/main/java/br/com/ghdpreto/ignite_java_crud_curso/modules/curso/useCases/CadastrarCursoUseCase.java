package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.ghdpreto.ignite_java_crud_curso.entities.CursoEntity;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos.CadastrarCursoDTO;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.repositories.CursoRepository;

@Service
public class CadastrarCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(CadastrarCursoDTO cadastrarCursoDTO) {

        System.out.println(cadastrarCursoDTO);

        CursoEntity curso = new CursoEntity();
        curso.setCategory(cadastrarCursoDTO.category());
        curso.setName(cadastrarCursoDTO.name());
        curso.setActive(true);

        return this.cursoRepository.save(curso);
    }

}
