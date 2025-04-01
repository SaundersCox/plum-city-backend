package com.plumcity.plum_city.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;

@Component
@Slf4j
public class WebClientFilters {

  /**
   * Logs request details and response status via the WebClient.filter() method. Make sure to add
   * this filter before sensitive data is added to the headers, params, or payload
   *
   * @return Side-effect logging filter for WebClient transparency
   */
  public ExchangeFilterFunction logCall() {
    return (request, next) -> {
      log.info("Request: {} {} {}", request.method(), request.url(), request.headers());
      return next.exchange(request)
          .doOnSuccess(response ->
              log.info("Response: {}", response.statusCode()));
    };
  }
}