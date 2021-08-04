package com.github.mibo.spring.app.control;

import com.github.mibo.spring.app.entity.User;
import com.github.mibo.spring.app.entity.UserStore;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

  private static final User.Role DEFAULT_ROLE = User.Role.USER;
  private final UserStore userStore;

  public UserService(UserStore userStore) {
    this.userStore = userStore;
  }

  public User createUser(String name, String password) {
    return createUser(name, password, DEFAULT_ROLE);
  }

  public User createUser(String name, String password, User.Role role) {
    User user = new User(name, password);
    user.setRole(role);
    return userStore.save(user);
  }

  public List<User> getAllUsers() {
    return userStore.findAll();
  }

  public Optional<User> updateUser(User user) {
    Optional<User> found = userStore.findByName(user.getName());
    if (found.isPresent()) {
      User update = User.createFrom(found.get());
      update.setPassword(user.getPassword());
      return Optional.of(userStore.save(update));
    }
    return found;
  }

  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    User user = userStore.findByName(name).orElseThrow(() -> new UsernameNotFoundException("User not found."));
    return org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
            .username(user.getName())
            .password(user.getPassword())
            .roles(user.getRole().name())
            .build();
  }
}
