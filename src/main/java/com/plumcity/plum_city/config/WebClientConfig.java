package com.plumcity.plum_city.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class WebClientConfig {

  @Bean
  public WebClient.Builder baseWebClient() {
    return WebClient.builder()
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
        .filter(logRequestFilter())
        .filter(logResponseFilter());
  }

  private ExchangeFilterFunction logRequestFilter() {
    return ExchangeFilterFunction.ofRequestProcessor(request -> {
      log.info("Request: {} {} {}", request.method(), request.url(), request.headers());
      return Mono.just(request);
    });
  }

  private ExchangeFilterFunction logResponseFilter() {
    return ExchangeFilterFunction.ofResponseProcessor(response -> {
      log.info("Response: {}", response.statusCode());
      return Mono.just(response);
    });
  }

}


