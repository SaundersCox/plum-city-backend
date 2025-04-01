package com.plumcity.plum_city.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

  private final WebClientFilters filters;

  private String apiKey;

  @Bean(name = "weatherClient")
  public WebClient weatherClient() {
    log.info("Creating WebClient for OpenWeather API");
    return WebClient.builder()
        .baseUrl("https://api.openweathermap.org/data/2.5")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
        .filter(filters.logCall()) // Log before adding API key
        .filter(addApiKeyQueryParam())
        .build();
  }

  /**
   * See the <a href="https://openweathermap.org/appid">OpenWeather docs</a>
   *
   * @return Updated request with apiKey query param
   */
  private ExchangeFilterFunction addApiKeyQueryParam() {
    return (request, next) -> {
      ClientRequest modifiedRequest = ClientRequest.from(request)
          .url(UriComponentsBuilder.fromUri(request.url())
              .queryParam("appid", apiKey)
              .build()
              .toUri())
          .build();
      return next.exchange(modifiedRequest);
    };
  }
}
