package com.github.mibo.spring.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // disable for basic version
    http.csrf().disable();

    http.authorizeRequests()
        .antMatchers("/v1/service/health", "/home").permitAll()
        .anyRequest().authenticated().and().httpBasic();
  }
}