package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos;

import java.sql.Timestamp;
import java.util.UUID;

public record CursoResponseDTO(
        UUID id,
        String name,
        String category,
        Boolean active,
        Timestamp createdAt,
        Timestamp updatedAt) {
}
