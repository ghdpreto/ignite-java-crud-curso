package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos;

import java.util.List;

public record CursosListResponseDTO(
                List<CursoResponseDTO> cursos) {

}
