package com.plumcity.plum_city;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class PlumCityApplication {

  public static void main(String[] args) {
    log.info("Environment Variables");
    System.getenv()
        .forEach(
            (key, value) -> {
              log.info(key + ": " + value);
            });
    SpringApplication.run(PlumCityApplication.class, args);
  }
}
