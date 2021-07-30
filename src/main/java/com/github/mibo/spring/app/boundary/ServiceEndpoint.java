package com.github.mibo.spring.app.boundary;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/service")
public class ServiceEndpoint {

  @GetMapping("/health")
  public ResponseEntity<String> health() {
    return ResponseEntity.ok("up");
  }
}
