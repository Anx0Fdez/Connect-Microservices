package org.exad.examenad_postgresql.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Value("${spring.application.version}")
    private String version;

    //nombre de la app
    @Value("${spring.application.name}")
    private String appName;

    //Metodo que devuelve una customizacion de swagger
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(appName)
                        .description("Microservicio de PostgreSQL")
                        .version(version));
    }
}
