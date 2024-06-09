package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos;

import jakarta.annotation.Nullable;

public record AtualizarCursoDTO(
                @Nullable String name,
                @Nullable String category) {
}
