package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CadastrarCursoDTO(
        @NotNull @NotEmpty String name,

        @NotNull @NotEmpty String category) {
}
