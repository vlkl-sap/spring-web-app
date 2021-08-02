package com.github.mibo.spring.app.boundary;

import com.github.mibo.spring.app.control.UserService;
import com.github.mibo.spring.app.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserEndpoint {

  private final UserService userService;

  public UserEndpoint(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("")
  public ResponseEntity<String> listUsers() {

    return ResponseEntity.ok(userService.getAllUsers().toString());
  }

  @PostMapping("")
  public ResponseEntity<String> createUser(@RequestBody User user) {
    User createdUser = userService.createUser(user.getName(), user.getPassword());
    return ResponseEntity.status(HttpStatus.CREATED).body(createdUser.toString());
  }

  @PutMapping("/{name}")
  public ResponseEntity<String> updateUser(@PathVariable("name") String name, @RequestBody User user) {
    if (!name.equals(user.getName())) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User name in url does not fit to JSON content");
    }

    Optional<User> updatedUser = userService.updateUser(user);
    if (updatedUser.isPresent()) {
      return ResponseEntity.ok(updatedUser.toString());
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with name is not known");
  }
}
