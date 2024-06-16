package br.com.ghdpreto.ignite_java_crud_curso.modules.curso.swagger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Remover curso", description = "Essa função é responsável por remover um curso")
@Parameter(in = ParameterIn.PATH, name = "id", description = "ID do curso")
@ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Sucess", content = @Content(mediaType = "application/json")),
        @ApiResponse(responseCode = "404", content = @Content(mediaType = "application/json"))
})
public @interface RemoverCursoSwagger {

}
