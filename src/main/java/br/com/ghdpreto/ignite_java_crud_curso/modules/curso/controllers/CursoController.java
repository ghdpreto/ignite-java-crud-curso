package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ghdpreto.ignite_java_crud_curso.entities.CursoEntity;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos.CadastrarCursoDTO;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.useCases.CadastrarCursoUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("curso")
public class CursoController {

    @Autowired
    private CadastrarCursoUseCase cadastrarCursoUseCase;

    @PostMapping()
    public ResponseEntity<CursoEntity> cadastrar(@Valid @RequestBody CadastrarCursoDTO cadastrarCursoDTO) {

        CursoEntity curso = this.cadastrarCursoUseCase.execute(cadastrarCursoDTO);

        return ResponseEntity.ok().body(curso);

    }
}
