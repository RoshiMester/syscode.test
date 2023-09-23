package com.syscode.syscode.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
public class SpringSecurityConfig {
  @Bean
  public InMemoryUserDetailsManager userDetailsManager() {
    UserDetails user =
        User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin")
            .roles("ADMIN")
            .build();
    return new InMemoryUserDetailsManager(user);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.cors();
    http.authorizeHttpRequests(
            (authorize) ->
                authorize
                    .requestMatchers(antMatcher("/api/v1/address"))
                    .hasRole("ADMIN")
                    .anyRequest()
                    .permitAll())
        .httpBasic(Customizer.withDefaults());
    return http.build();
  }
}
