package com.plumcity.plum_city.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ConfigurationProperties(prefix = "app.the-cat-api")
@RequiredArgsConstructor
public class CatClientConfig {

  private final WebClientFilters filters;

  private String apiKey;

  @Bean(name = "catClient")
  public WebClient catClient() {
    return WebClient.builder()
        .baseUrl("https://api.thecatapi.com/v1")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
        .filter(filters.logCall()) // Log before adding API key
        .defaultHeader("x-api-key", apiKey)
        .build();
  }
}
