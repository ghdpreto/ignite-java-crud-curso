package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos;

import java.util.List;

import br.com.ghdpreto.ignite_java_crud_curso.entities.CursoEntity;

public record CursosListResponseDTO(
        List<CursoEntity> cursos) {

}
