package com.plumcity.plum_city.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "custom")
@Getter
@Setter
public class CustomConfig {

  private String myValue;
  private Integer myNum;

  @NestedConfigurationProperty
  private MoreSettings moreSettings = new MoreSettings();

  @Getter
  @Setter
  public static class MoreSettings {

    private Boolean fastMode;
  }
}
