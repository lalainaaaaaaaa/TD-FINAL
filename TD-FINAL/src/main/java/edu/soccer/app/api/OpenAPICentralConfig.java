package edu.soccer.app.api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPICentralConfig {

    @Bean
    public OpenAPI soccerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Soccer Championship API")
                        .version("1.0")
                        .description("API documentation for Soccer Championship project"));
    }
}
