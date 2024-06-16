package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.swagger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos.CursoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Ativar/desativar curso", description = "Essa função é responsável por ativa ou desativar um curso")
@Parameter(in = ParameterIn.PATH, name = "id", description = "ID do curso")
@ApiResponses(value = {
                @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursoResponseDTO.class))),
                @ApiResponse(responseCode = "404", content = @Content(mediaType = "application/json"))
})

public @interface AtivarCursoSwagger {

}
