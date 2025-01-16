package vttp5.paf.day24.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

    // OpenAPI JSON: http://localhost:8080/v3/api-docs
    // Swagger UI: http://localhost:8080/swagger-ui.html

    // OpenAPI JSON documentation is available at /v3/api-docs
    // Swagger UI can be accessed at /swagger-ui.html or /swagger-ui/index.html

    // change the path of the OpenAPI documentation by setting the following property in your application.properties
    // springdoc.api-docs.path=/custom-api-docs
    // customize the Swagger UI path
    // springdoc.swagger-ui.path=/custom-swagger-ui.html

    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI().info(
            new Info()
            .title("PAF Day 24")
            .description("Testing API using OpenAPI public interface")
            .version("1.0")
        );
    }
    
}
