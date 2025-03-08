package com.plumcity.plum_city.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI()
        .info(new Info()
            .title("Plum City API")
            .version("1.0")
            .description("API Documentation")
            .contact(new Contact()
                .name("Saunders Cox")
                .email("saunderscox@gmail.com")))
        .externalDocs(new ExternalDocumentation()
            .description("Additional Documentation")
            .url("https://github.com/SaundersCox/plum-city-backend"));
  }
}
