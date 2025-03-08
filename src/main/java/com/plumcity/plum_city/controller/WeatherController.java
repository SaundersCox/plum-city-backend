package com.plumcity.plum_city.controller;

import com.plumcity.plum_city.dto.WeatherDto;
import com.plumcity.plum_city.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {

  private final WeatherService weatherService;


  @GetMapping
  public Mono<WeatherDto> getWeather(String city) {
    return weatherService.getWeatherForCity(city);
  }
}
