package com.github.mibo.spring.app.boundary;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserEndpoint {

  @GetMapping("")
  public ResponseEntity<String> listUsers() {
    return ResponseEntity.ok("user");
  }
}
