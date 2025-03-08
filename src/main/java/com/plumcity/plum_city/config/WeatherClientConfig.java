package com.plumcity.plum_city.config;

import java.net.URI;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
@ConfigurationProperties(prefix = "app.web-client.open-weather")
@Slf4j
@RequiredArgsConstructor
@Getter
@Setter
public class WeatherClientConfig {

  private final WebClient.Builder webClientBuilder;

  private String apiKey;

  @Bean(name = "weatherClient")
  public WebClient weatherClient() {
    log.info("Creating a WebClient for OpenWeather with apiKey: {}", apiKey);
    return webClientBuilder
        .baseUrl("https://api.openweathermap.org/data/2.5")
        .filter(addApiKeyQueryParam())
        .build();
    // logic that applies only to this client
  }

  private ExchangeFilterFunction addApiKeyQueryParam() {
    return (request, next) -> {
      URI originalUri = request.url();
      URI newUri = UriComponentsBuilder.fromUri(originalUri)
          .queryParam("appid", apiKey)
          .build()
          .toUri();
      ClientRequest modifiedRequest = ClientRequest.from(request)
          .url(newUri)
          .build();
      log.info("{}", newUri);
      return next.exchange(modifiedRequest);
    };
  }
}
