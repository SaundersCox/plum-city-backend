package com.plumcity.plum_city.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class DogClientConfig {

  @Bean
  @Qualifier("dogClient")
  public WebClient dogClient() {
    return WebClient.builder()
        .baseUrl("https://dog.ceo/api")
        .build();
    // logic that applies only to this client
  }
}
