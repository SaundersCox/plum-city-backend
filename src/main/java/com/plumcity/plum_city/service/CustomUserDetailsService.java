package com.plumcity.plum_city.service;

import com.plumcity.plum_city.model.User;
import com.plumcity.plum_city.repository.UserRepository;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user =
        userRepository
            .findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole());

    return new org.springframework.security.core.userdetails.User(
        user.getUsername(), user.getPassword(), Collections.singletonList(authority));
  }
}
