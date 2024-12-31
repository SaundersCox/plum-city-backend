package com.plumcity.plum_city.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping
  public ResponseEntity<String> echo(@RequestParam(defaultValue = "dude") String name) {
    return new ResponseEntity<>("Welcome " + (name == null ? "" : name), HttpStatus.OK);
  }
}
