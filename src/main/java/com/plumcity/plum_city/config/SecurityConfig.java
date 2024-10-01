package com.plumcity.plum_city.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
        .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/home", true)
            .permitAll())
        .httpBasic(httpBasic -> httpBasic.authenticationEntryPoint(
            (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED)))
        .build();
  }

  // @Bean
  // public UserDetailsService userDetailsService() {
  // UserDetails user = User.builder()
  // .username("admin")
  // .password(passwordEncoder().encode("admin123")) // Custom password hashed
  // .roles("USER")
  // .build();

  // return new InMemoryUserDetailsManager(user);
  // }

  // @Bean
  // public PasswordEncoder passwordEncoder() {
  // return new BCryptPasswordEncoder(); // Use BCrypt for password encoding
  // }
}
