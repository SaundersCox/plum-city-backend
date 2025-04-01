package com.plumcity.plum_city.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class CatService {

  @Qualifier(value = "catClient")
  private final WebClient catClient;

  //  v1/images/search?limit=10
  public Mono<String> getImages(int limit) {
    return catClient.get()
        .uri(uriBuilder -> uriBuilder
            .path("/images/search?limit")
            .queryParam("limit", limit)
            .build())
        .retrieve()
        .bodyToMono(String.class);
  }
}
