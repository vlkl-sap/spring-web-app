package com.github.mibo.spring.app.config;

import com.github.mibo.spring.app.entity.User;
import com.github.mibo.spring.app.entity.UserStore;
import java.util.Optional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class DatabaseContentInit implements ApplicationRunner {

  private static final String DATABASE_DEFAULT_USER_CREATE = "database.default-user.create";

  private final Environment environment;
  private final UserStore userStore;

  public DatabaseContentInit(Environment environment, UserStore userStore) {
    this.environment = environment;
    this.userStore = userStore;
  }

  @Override
  public void run(ApplicationArguments args) {
    boolean createDatabaseDefaultUser =
        environment.getProperty(DATABASE_DEFAULT_USER_CREATE, Boolean.class, Boolean.FALSE);
    if (createDatabaseDefaultUser) {
      populateDatabaseDefaultUser();
    }

  }

  private void populateDatabaseDefaultUser() {
    Optional<User> user = userStore.findByName("user");
    if (user.isEmpty()) {
      User defaultUser = new User("user", "password");
      defaultUser.setRole(User.Role.ADMIN);
      userStore.saveAndFlush(defaultUser);
    }
  }

}