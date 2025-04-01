package com.plumcity.plum_city.exception;

import lombok.Getter;

@Getter
public abstract class ApiException extends RuntimeException {

  private final String errorCode;

  protected ApiException (String errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

}
