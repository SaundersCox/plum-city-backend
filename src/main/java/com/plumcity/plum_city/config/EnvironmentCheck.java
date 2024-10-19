package com.plumcity.plum_city.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EnvironmentCheck {

  @Value("${DB_USERNAME}")
  private String dbUsername;

  @Value("${DB_PASSWORD}")
  private String dbPassword;

  @PostConstruct
  public void init() {
    log.info("DB_USERNAME: " + dbUsername);
    log.info("DB_PASSWORD: " + dbPassword);
  }
}
