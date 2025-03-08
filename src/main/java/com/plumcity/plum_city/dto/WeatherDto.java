package com.plumcity.plum_city.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class WeatherDto {

  private Coordinates coord;
  private List<Weather> weather;
  private String base;
  private MainData main;
  private int visibility;
  private Wind wind;
  private Clouds clouds;
  private long dt;
  private SystemInfo sys;
  private int timezone;
  private long id;
  private String name;
  private int cod;

  @Data
  public static class Coordinates {

    private double lon;
    private double lat;
  }

  @Data
  public static class Weather {

    private int id;
    private String main;
    private String description;
    private String icon;
  }

  @Data
  public static class MainData {

    private double temp;

    @JsonProperty("feels_like")
    private double feelsLike;

    @JsonProperty("temp_min")
    private double tempMin;

    @JsonProperty("temp_max")
    private double tempMax;

    private int pressure;
    private int humidity;

    @JsonProperty("sea_level")
    private int seaLevel;

    @JsonProperty("grnd_level")
    private int grndLevel;
  }

  @Data
  public static class Wind {

    private double speed;
    private int deg;
  }

  @Data
  public static class Clouds {

    private int all;
  }

  @Data
  public static class SystemInfo {

    private int type;
    private long id;
    private String country;
    private long sunrise;
    private long sunset;
  }
}