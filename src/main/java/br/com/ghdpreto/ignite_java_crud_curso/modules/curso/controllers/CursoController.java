package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.controllers;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ghdpreto.ignite_java_crud_curso.entities.CursoEntity;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos.AtualizarCursoDTO;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos.CadastrarCursoDTO;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos.CursoResponseDTO;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos.CursosListResponseDTO;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.useCases.AtualizarCursoUseCase;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.useCases.CadastrarCursoUseCase;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.useCases.ListarCursosUseCase;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("curso")
public class CursoController {

    @Autowired
    private CadastrarCursoUseCase cadastrarCursoUseCase;

    @Autowired
    private ListarCursosUseCase listarCursosUseCase;

    @Autowired
    private AtualizarCursoUseCase atualizarCursoUseCase;

    @PostMapping()
    public ResponseEntity<CursoEntity> cadastrar(@Valid @RequestBody CadastrarCursoDTO cadastrarCursoDTO) {

        CursoEntity curso = this.cadastrarCursoUseCase.execute(cadastrarCursoDTO);

        return ResponseEntity.ok().body(curso);

    }

    @GetMapping("")
    public ResponseEntity<CursosListResponseDTO> getCursos() {

        List<CursoResponseDTO> cursos = this.listarCursosUseCase.execute();

        return ResponseEntity.ok().body(new CursosListResponseDTO(cursos));

    }

    @PutMapping("{id}")
    public ResponseEntity<Object> atualizar(@PathVariable String id,
            @Valid @RequestBody AtualizarCursoDTO atualizarCursoDTO) {

        CursoEntity curso = this.atualizarCursoUseCase.execute(atualizarCursoDTO, UUID.fromString(id));

        return ResponseEntity.ok().body(curso);

    }
}
