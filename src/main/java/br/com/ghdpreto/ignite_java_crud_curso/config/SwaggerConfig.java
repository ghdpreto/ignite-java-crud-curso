package br.com.ghdpreto.ignite_java_crud_curso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * Classe responsável por toda a configuração referente ao swagger
 */

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI openAPI() {
        return new OpenAPI().info(criarInfo());

    }

    private Info criarInfo() {
        return new Info()
                .title("Crud de cursos")
                .description("API responsável pela gestão de cursos")
                .version("1");
    }
}
