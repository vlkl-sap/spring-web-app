package com.github.mibo.spring.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class User {
  public enum Role {USER, ADMIN}

  @Id
  private String uuid;
  @Column(unique = true)
  private String name;
  private String password;
  private Role role;

  public User(String name, String password) {
    this.uuid = UUID.randomUUID().toString();
    this.name = name;
    this.password = password;
    this.role = Role.USER;
  }

  public User() {

  }

  public static User createFrom(User user) {
    User u = new User();
    u.uuid = user.uuid;
    u.name = user.name;
    u.password = user.password;
    u.role = user.role;
    return u;
  }

  public String getUuid() {
    return uuid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(uuid, user.uuid)
        && Objects.equals(name, user.name)
        && Objects.equals(password, user.password)
        && Objects.equals(role, user.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, name, password, role);
  }

  @Override
  public String toString() {
    return "User{" +
        "uuid='" + uuid + '\'' +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", role='" + role + '\'' +
        '}';
  }
}
