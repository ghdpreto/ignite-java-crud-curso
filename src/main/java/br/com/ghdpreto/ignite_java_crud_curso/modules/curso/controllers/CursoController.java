package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.swagger.AtivarCursoSwagger;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.swagger.AtualizarCursoSwagger;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.swagger.CadastrarCursoSwagger;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.swagger.ListarCursosSwagger;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.swagger.RemoverCursoSwagger;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.useCases.AtivarCursoUseCase;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.useCases.AtualizarCursoUseCase;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.useCases.CadastrarCursoUseCase;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.useCases.ListarCursosUseCase;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.useCases.RemoverCursoUseCase;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    @Autowired
    private AtivarCursoUseCase ativarCursoUseCase;

    @Autowired
    private RemoverCursoUseCase removerCursoUseCase;

    @PostMapping()
    @CadastrarCursoSwagger
    public ResponseEntity<CursoResponseDTO> cadastrar(@Valid @RequestBody CadastrarCursoDTO cadastrarCursoDTO) {

        CursoEntity curso = this.cadastrarCursoUseCase.execute(cadastrarCursoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(new CursoResponseDTO(curso));
    }

    @GetMapping()
    @ListarCursosSwagger
    public ResponseEntity<CursosListResponseDTO> getCursos() {

        List<CursoEntity> cursos = this.listarCursosUseCase.execute();

        return ResponseEntity.ok().body(new CursosListResponseDTO(cursos));

    }

    @PutMapping("{id}")
    @AtualizarCursoSwagger
    public ResponseEntity<CursoResponseDTO> atualizar(@PathVariable String id,
            @Valid @RequestBody AtualizarCursoDTO atualizarCursoDTO) {

        CursoEntity curso = this.atualizarCursoUseCase.execute(atualizarCursoDTO, UUID.fromString(id));

        return ResponseEntity.ok().body(new CursoResponseDTO(curso));

    }

    @PatchMapping("{id}/active")
    @AtivarCursoSwagger
    public ResponseEntity<CursoResponseDTO> ativar(@PathVariable String id) {
        CursoEntity curso = this.ativarCursoUseCase.execute(UUID.fromString(id));

        return ResponseEntity.ok().body(new CursoResponseDTO(curso));
    }

    @DeleteMapping("{id}")
    @RemoverCursoSwagger
    public ResponseEntity<Object> deletear(@PathVariable String id) {
        this.removerCursoUseCase.execute(UUID.fromString(id));

        return ResponseEntity.noContent().build();
    }
}
