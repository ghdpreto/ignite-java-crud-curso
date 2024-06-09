package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nullable;

public record AtualizarCursoDTO(
        @Nullable String name,
        @Nullable String category) {
}
