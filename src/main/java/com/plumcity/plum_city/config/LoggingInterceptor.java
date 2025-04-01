package com.plumcity.plum_city.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class LoggingInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler) {
    log.info("➡️ Incoming {} request to {} from {}",
        request.getMethod(), request.getRequestURI(), request.getRemoteAddr());

    if ("POST" .equalsIgnoreCase(request.getMethod())
        || "PUT" .equalsIgnoreCase(request.getMethod())) {
      try {
        String body = new String(request.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        log.info("📥 Request Body: {}", body);
      } catch (IOException e) {
        log.warn("⚠️ Failed to read request body");
      }
    }

    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) {
    log.info("✅ Completed {} with status: {}", request.getRequestURI(), response.getStatus());
    if (ex != null) {
      log.error("❌ Exception during request: {}", ex.getMessage(), ex);
    }
  }
}
