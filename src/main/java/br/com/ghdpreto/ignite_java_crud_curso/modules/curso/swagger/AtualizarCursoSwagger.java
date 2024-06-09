package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.swagger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.ghdpreto.ignite_java_crud_curso.exceptions.dtos.ErroValidacaoResponseDTO;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos.CursoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Atualizar curso", description = "Essa função é responsável por atualizar dados de um curso")
@Parameter(in = ParameterIn.PATH, name = "id", description = "ID do curso")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursoResponseDTO.class))),
        @ApiResponse(responseCode = "400", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ErroValidacaoResponseDTO.class)))),
        @ApiResponse(responseCode = "404", content = @Content(mediaType = "application/json")),
})

public @interface AtualizarCursoSwagger {

}
