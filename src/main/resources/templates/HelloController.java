package com.plumcity.plum_city.templates;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/greet")
  public String greet(Model model) {
    model.addAttribute("message", "Hello, Thymeleaf!");
    return "greet";
  }
}
