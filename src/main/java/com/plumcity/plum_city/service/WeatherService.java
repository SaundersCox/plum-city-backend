package com.plumcity.plum_city.service;

import com.plumcity.plum_city.dto.WeatherDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

  @Qualifier("weatherClient")
  private final WebClient weatherClient;

  public Mono<WeatherDto> getWeatherForCity(String city) {
    return weatherClient.get()
        .uri(uriBuilder -> uriBuilder
            .path("/weather")
            .queryParam("q", "London")
            .build())
        .retrieve()
        .bodyToMono(WeatherDto.class);
  }
}
