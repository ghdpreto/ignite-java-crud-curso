package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.swagger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.dtos.CursosListResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Listar cursos", description = "Essa função é responsável por listar todos os cursos cadastrados")
@ApiResponses(value = {
                @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursosListResponseDTO.class)))
})

public @interface ListarCursosSwagger {

}
